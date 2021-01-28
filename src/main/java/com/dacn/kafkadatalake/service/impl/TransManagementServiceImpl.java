package com.dacn.kafkadatalake.service.impl;

import com.dacn.kafkadatalake.dto.request.OrderConsumerDTO;
import com.dacn.kafkadatalake.dto.response.BaseResponseDTO;
import com.dacn.kafkadatalake.model.Order;
import com.dacn.kafkadatalake.repository.OrderRepository;
import com.dacn.kafkadatalake.service.AmazonS3ClientService;
import com.dacn.kafkadatalake.service.TransManagementService;
import com.dacn.kafkadatalake.utils.DateTimeUtils;
import com.dacn.kafkadatalake.utils.GsonUtils;
import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static com.dacn.kafkadatalake.enumeration.ReturnCodeEnum.SUCCESSFUL;


@Service
public class TransManagementServiceImpl implements TransManagementService {

    private static Logger LOGGER = LoggerFactory.getLogger(TransManagementServiceImpl.class);

    private final OrderRepository orderRepository;
    private final AmazonS3ClientService amazonS3ClientService;

    @Autowired
    public TransManagementServiceImpl(OrderRepository orderRepository,
                                      AmazonS3ClientService amazonS3ClientService) {

        this.orderRepository = orderRepository;
        this.amazonS3ClientService = amazonS3ClientService;
    }


    @Override
    public BaseResponseDTO createOrder(OrderConsumerDTO request) {
        BaseResponseDTO response = new BaseResponseDTO();
        try {
            Order order = new Order();
            order.doMappingEntity(request);
            order = orderRepository.save(order);

            LOGGER.info("createOrder successful : {} ", GsonUtils.toJsonString(order));
            response.success(SUCCESSFUL.getMessage());
        } catch (Exception ex) {
            LOGGER.info("createOrder exception: {}", ex);
            response.fail(ex.getMessage());
        }
        return response;
    }

    @KafkaListener(topics = "${kafka.logTopic}")
    public void listenMessage(ConsumerRecord<String, Object> cr,
                              @Payload String logMessage) {
        LOGGER.info("logMessage: {}", logMessage);
        try {
            if (StringUtils.isNotBlank(logMessage)) {
                OrderConsumerDTO request = new Gson().fromJson(logMessage, OrderConsumerDTO.class);
                writeLogToCSV(request);
            }
        } catch (Exception ex) {

        }
    }

    private Boolean writeLogToCSV(OrderConsumerDTO request) {
        try {
            String[] headers = { "CusID", "CreatedDate", "Status", "TotalAmount",
                    "ReceiveName", "ReceivePhone", "ReceiveLocation", "VolumeProduction",
                    "TypeProduct", "Description", "SenderName", "SenderPhone", "SenderLocation",
                    "ExpectedDate", "RecieveDate", "RecieveAddress", "SenderAddress"};

            String currentDateTimeFormat = DateTimeUtils.getCurrentDateTime();
            String fileName = "orderLog" + currentDateTimeFormat;
            String outputFile = "./storage/" + fileName + ".csv";

            BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile),
                    StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE);
            try (CSVPrinter printer = CSVFormat.DEFAULT.withHeader(headers).withSkipHeaderRecord(true)
                    .print(writer)) {
                printer.printRecord(request.getCusID(), request.getCreatedDate(),
                        request.getStatus(), request.getTotalAmount(), request.getReceiverName(),
                        request.getReceiverPhone(), request.getReceiveLocation(), request.getVolumeProduction(),
                        request.getTypeProduct(), request.getDescription(), request.getSenderName(), request.getSenderPhone(),
                        request.getSenderLocation(), request.getExpectedDate(), request.getRecieveDate(),
                        request.getRecieveAddress(), request.getSenderAddress());

                printer.flush();

                writer.close();
            }
        } catch (Exception ex) {
            LOGGER.error("writeLogToCSV exception - ", ex);
        }
        return false;
    }

    @Override
    public BaseResponseDTO orderReaderFile() {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        List<OrderConsumerDTO> response = new ArrayList<>();
        try {
            String[] headers = { "CusID", "CreatedDate", "Status", "TotalAmount",
                    "ReceiveName", "ReceivePhone", "ReceiveLocation", "VolumeProduction",
                    "TypeProduct", "Description", "SenderName", "SenderPhone", "SenderLocation",
                    "ExpectedDate", "RecieveDate", "RecieveAddress", "SenderAddress"};

            String currentDateTimeFormat = DateTimeUtils.getCurrentDateTime();
            String fileName = "orderLog" + currentDateTimeFormat;
            String outputFile = "./storage/" + fileName + ".csv";

            BufferedReader reader = Files.newBufferedReader(Paths.get(outputFile));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(headers).withIgnoreHeaderCase().withTrim());

            LOGGER.info("orderReaderFile start........");

            for (CSVRecord csvRecord : csvParser) {
                OrderConsumerDTO order = new OrderConsumerDTO();
                order.setCusID(Integer.parseInt(csvRecord.get("CusID")));
                order.setCreatedDate(csvRecord.get("CreatedDate"));
                order.setStatus(Integer.parseInt(csvRecord.get("Status")));
                order.setTotalAmount(Float.parseFloat(csvRecord.get("TotalAmount")));
                order.setReceiverName(csvRecord.get("ReceiveName"));
                order.setReceiverPhone(Integer.parseInt(csvRecord.get("ReceivePhone")));
                order.setReceiveLocation(Integer.parseInt(csvRecord.get("ReceiveLocation")));
                order.setVolumeProduction(Float.parseFloat(csvRecord.get("VolumeProduction")));
                order.setTypeProduct(csvRecord.get("TypeProduct"));
                order.setDescription(csvRecord.get("Description"));
                order.setDescription(csvRecord.get("SenderName"));
                order.setDescription(csvRecord.get("SenderPhone"));
                order.setDescription(csvRecord.get("SenderLocation"));
                order.setDescription(csvRecord.get("ExpectedDate"));
                order.setDescription(csvRecord.get("RecieveDate"));
                order.setDescription(csvRecord.get("RecieveAddress"));
                order.setDescription(csvRecord.get("SenderAddress"));
                response.add(order);
                createOrder(order);
            }

            uploadFile(fileName + ".csv", outputFile);
            baseResponseDTO.success("Upload file to AWS S3 successful.", response);
        } catch (IOException e) {
            e.printStackTrace();
            baseResponseDTO.fail(e.getMessage());
        }
        return baseResponseDTO;
    }

    @Async
    boolean uploadFile(String fileName, String pathName) {
        try {
            Path path = Paths.get(pathName);
            String contentType = "text/plain";
            byte[] content = null;
            try {
                content = Files.readAllBytes(path);
            } catch (final IOException e) {
            }
            MultipartFile multipartFile = new MockMultipartFile(fileName,
                    fileName, contentType, content);

            amazonS3ClientService.uploadFileToS3Bucket(multipartFile, true);
            LOGGER.info("upload file successful with fileName: {}, path: {}", fileName, pathName);
        } catch (Exception ex) {
           LOGGER.info("upload file exception with fileName: {}, path: {}, ex: {}", fileName, pathName, ex);
        }
        return false;
    }

//    @Bean
////    public void flinkConsumer() {
////        List<String> topics = Arrays.asList("odd", "even");
////        Properties properties = new Properties();
////        properties.setProperty("bootstrap.servers", "localhost:9092");
////        properties.setProperty("group.id", "flink-consumer");
////        FlinkKafkaConsumer010<String> consumer = new FlinkKafkaConsumer010<>(topics, new SimpleStringSchema(), properties);
////        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
////        DataStreamSource<String> stream = env.addSource(consumer);
////        stream.map(new FlinkMapper()).setParallelism(4);
////        try {
////            env.execute();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }

}
