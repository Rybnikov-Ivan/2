package com.example2.controller;

import com.example2.model.Promotion;
import com.example2.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(name = "promo/")
public class PromotionController {

    private final PromotionService promotionService;
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Promotion promotion) {
        int promotionId = CLIENT_ID_HOLDER.incrementAndGet();
        promotion.setId(promotionId);
        promotionService.createPromotion(promotion);
        return new ResponseEntity<>(promotion.getId(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        promotionService.getAllPromotion();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(promotionService.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Promotion promotion) {
        promotionService.updatePromotion(id, promotion);
        return new ResponseEntity<>(promotion, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        promotionService.deletePromotion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
