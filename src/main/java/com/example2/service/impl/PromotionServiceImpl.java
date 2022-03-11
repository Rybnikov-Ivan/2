package com.example2.service.impl;

import com.example2.model.Promotion;
import com.example2.service.PromotionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    public static final List<Promotion> PROMOTION_LIST = new ArrayList<>();

    @Override
    public void createPromotion(Promotion promotion) {
        PROMOTION_LIST.add(promotion);
    }

    @Override
    public List<Promotion> getAllPromotion() {
        List<Promotion> promotions = new ArrayList<>();
        for (int i = 0; i < PROMOTION_LIST.size(); i++) {
            Promotion promotion = new Promotion();
            promotion.setId(PROMOTION_LIST.get(i).getId());
            promotion.setName(PROMOTION_LIST.get(i).getName());
            promotion.setDescription(PROMOTION_LIST.get(i).getDescription());
        }
        return promotions;
    }

    @Override
    public Promotion findById(int id) {
        for (Promotion promotion : PROMOTION_LIST) {
            if (promotion.getId() == id) {
                return promotion;
            }
            else {
                return null;
            }
        }
        return null;
    }

    @Override
    public void updatePromotion(int id, Promotion promotion) {
        for (Promotion findPromotion : PROMOTION_LIST) {
            if (findPromotion.getId() == id) {
                findPromotion.setName(promotion.getName());
                findPromotion.setDescription(promotion.getDescription());
            }
        }
    }

    @Override
    public void deletePromotion(int id) {
        PROMOTION_LIST.removeIf(promotion -> promotion.getId() == id);
    }
}
