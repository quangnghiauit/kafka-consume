package com.dacn.kafkadatalake.controllers;

import com.dacn.kafkadatalake.service.TransManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trans")
public class TransManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransManagementController.class);

    @Autowired
    private TransManagementService transManagementService;

    @RequestMapping(value = "/reader-csv", method = RequestMethod.GET)
    public ResponseEntity<?> readerCsv() {
        return new ResponseEntity<>(transManagementService.orderReaderFile(), HttpStatus.OK);
    }
}
