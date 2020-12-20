//package com.dacn.kafkadatalake.service.impl;
//
//import com.dacn.kafkadatalake.service.OrderRequest;
//import com.google.gson.Gson;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.flink.api.common.functions.MapFunction;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class FlinkMapper implements MapFunction<String, String> {
//    private static Logger LOGGER = LoggerFactory.getLogger(FlinkMapper.class);
//
//    @Override
//    public String map(String message) throws Exception {
//        LOGGER.info("logMessage: {}", message);
//        if (StringUtils.isNotBlank(message)) {
//            OrderRequest request = new Gson().fromJson(message, OrderRequest.class);
//            LOGGER.info("object: {}", request.getCusID());
//
//        }
//        return message;
//    }
//}
