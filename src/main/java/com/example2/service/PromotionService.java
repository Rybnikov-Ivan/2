package com.example2.service;

import com.example2.model.Promotion;

import java.util.List;

public interface PromotionService {

    void createPromotion(Promotion promotion);

    List<Promotion> getAllPromotion();

    Promotion findById(int id);

    void updatePromotion(int id, Promotion promotion);

    void deletePromotion(int id);
}
