package com.intech.model.service;

import com.intech.model.entity.ActionType;
import com.intech.model.entity.Purchase;
import com.intech.model.entity.Subscription;
import com.intech.model.repository.PurchaseRepository;
import com.intech.model.repository.SubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.Timestamp;

/**
 *  Сервис получает сообщение и по определенной логике записывает его в базу данных
 */
@Service
public class SubscriberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberService.class);
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    public Model saveToDB(Model model) {
        int msisdn = (int) model.getAttribute("msisdn");
        Timestamp timestamp = new Timestamp((Long) model.getAttribute("timestamp"));
        ActionType action = (ActionType) model.getAttribute("action");
        if (action == ActionType.PURCHASE){
            Purchase p = new Purchase(msisdn, action, timestamp);
            purchaseRepository.save(p);
            LOGGER.info("Saved to purchase - {}", model);
        }else {
            Subscription s = new Subscription(msisdn, action, timestamp);
            subscriptionRepository.save(s);
            LOGGER.info("Saved to subscription - {}", model);
        }
        return model;
    }

    public Iterable<Purchase> getPurchases() {
        Iterable<Purchase> getPurchases = purchaseRepository.findAll();
        System.out.println(getPurchases);
        return getPurchases;
    }

    public Iterable<Subscription> getSubscriptions() {
        return subscriptionRepository.findAll();
    }
}
