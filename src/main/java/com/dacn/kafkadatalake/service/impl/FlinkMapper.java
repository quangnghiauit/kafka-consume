package com.dacn.kafkadatalake.service.impl;

import org.apache.flink.api.common.functions.MapFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlinkMapper implements MapFunction<String, String> {
    private static Logger LOGGER = LoggerFactory.getLogger(FlinkMapper.class);

    @Override
    public String map(String message) throws Exception {
        LOGGER.info("logMessage: {}", message);
        return message;
    }
}
