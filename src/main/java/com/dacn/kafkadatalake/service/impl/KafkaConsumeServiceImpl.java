package com.dacn.kafkadatalake.service.impl;

import com.dacn.kafkadatalake.service.KafkaConsumeService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumeServiceImpl implements KafkaConsumeService {
    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumeServiceImpl.class);

    @KafkaListener(topics = "${kafka.logTopic}")
    public void listenMessage(ConsumerRecord<String, Object> cr,
                              @Payload String logMessage) {
        LOGGER.info("logMessage: {}", logMessage);
        try {

        } catch (Exception ex) {
            LOGGER.error("Kafka listenMessage exception - ", ex);
        }

    }

}
