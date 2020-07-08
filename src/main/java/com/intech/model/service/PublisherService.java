package com.intech.model.service;

import com.intech.model.entity.ActionType;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Сервис генерации и отправки сообщения подписчику (subscriber)
 */
@Service
public class PublisherService {
    private final int MIN_VALUE = 10000000;
    private final int MAX_VALUE = 100000000;

    public int generateMSISDN() {
        Random random = new Random();
        return random.ints(MIN_VALUE, MAX_VALUE)
                .findFirst()
                .getAsInt();
    }

    public Enum<ActionType> generateAction() {
        return ActionType.values()[new Random().nextInt(ActionType.values().length)];
    }

    public long generateTimestamp() {
        return System.currentTimeMillis();
    }
}
