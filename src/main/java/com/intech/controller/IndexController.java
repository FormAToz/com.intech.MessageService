package com.intech.controller;

import com.intech.model.entity.Purchase;
import com.intech.model.entity.Subscription;
import com.intech.model.service.ModelService;
import com.intech.model.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    SubscriberService subscriberService;
    @Autowired
    ModelService modelService;

    @GetMapping
    public String get(Model model) {
        Iterable<Purchase> purchases = subscriberService.getPurchases();
        Iterable<Subscription> subscriptions = subscriberService.getSubscriptions();
        model.addAttribute("purchases", purchases);
        model.addAttribute("subscriptions", subscriptions);
        return "index";
    }

    @PostMapping
    public String post(Model model) {
        model.addAllAttributes(modelService.getModel());
        subscriberService.saveToDB(model);
        System.out.println(model);
        return "redirect:/index";
    }
}
