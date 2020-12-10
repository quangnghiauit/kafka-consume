package com.dacn.kafkadatalake.service.impl;

import com.dacn.kafkadatalake.service.KafkaConsumeService;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Service
public class KafkaConsumeServiceImpl implements KafkaConsumeService {
    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumeServiceImpl.class);

//    @KafkaListener(topics = "${kafka.logTopic}")
//    public void listenMessage(ConsumerRecord<String, Object> cr,
//                              @Payload String logMessage) {
//        LOGGER.info("logMessage: {}", logMessage);
//        try {
//
//        } catch (Exception ex) {
//            LOGGER.error("Kafka listenMessage exception - ", ex);
//        }
//
//    }

    @Bean
    public void flinkConsumer() {
        List<String> topics = Arrays.asList("odd", "even");
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("group.id", "flink-consumer");
        FlinkKafkaConsumer010<String> consumer = new FlinkKafkaConsumer010<>(topics, new SimpleStringSchema(), properties);
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> stream = env.addSource(consumer);
        stream.map(new FlinkMapper()).setParallelism(4);
        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
