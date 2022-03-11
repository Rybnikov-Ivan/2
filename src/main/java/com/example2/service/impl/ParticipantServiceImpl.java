package com.example2.service.impl;

import com.example2.model.Participant;
import com.example2.model.Promotion;
import com.example2.service.ParticipantService;

import static com.example2.service.impl.PromotionServiceImpl.PROMOTION_LIST;

public class ParticipantServiceImpl implements ParticipantService {
    @Override
    public int addParticipantToPromotion(int promoId, Participant participant) {
        for (int i = 0; i < PROMOTION_LIST.size(); i++) {
            if (promoId == PROMOTION_LIST.get(i).getId()) {
                Promotion promotion = new Promotion();
            }
        }
        return 0;
    }

    @Override
    public void deleteParticipantFromPromotion(int participantId) {

    }
}
