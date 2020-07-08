package com.intech.controller;

import com.intech.model.service.ModelService;
import com.intech.model.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {
    @Autowired
    SubscriberService subscriberService;
    @Autowired
    ModelService modelService;

    @GetMapping
    public ResponseEntity get(Model model) {
        Model model1 = model.addAllAttributes(modelService.getModel());
        return ResponseEntity.ok().body(model);
    }

    @PostMapping
    public ResponseEntity post(Model model) {
        model.addAllAttributes(modelService.getModel());
        Model response = subscriberService.saveToDB(model);
        return ResponseEntity.ok().body(response);
    }
}
