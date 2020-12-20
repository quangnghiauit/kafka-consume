package com.dacn.kafkadatalake.service;

import com.dacn.kafkadatalake.dto.request.OrderConsumerDTO;
import com.dacn.kafkadatalake.dto.response.BaseResponseDTO;

public interface TransManagementService {

    BaseResponseDTO createOrder(OrderConsumerDTO request);

    BaseResponseDTO orderReaderFile();
}
