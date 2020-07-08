package com.intech.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Сервис создания отображаемой модели
 */
@Service
public class ModelService {
    @Autowired
    private PublisherService publisherService;

    public HashMap<String, Object> getModel() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msisdn", publisherService.generateMSISDN());
        map.put("action", publisherService.generateAction());
        map.put("timestamp", publisherService.generateTimestamp());
        return map;
    }
}
