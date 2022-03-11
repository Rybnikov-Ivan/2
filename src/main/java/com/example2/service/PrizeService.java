package com.example2.service;

import com.example2.model.Prize;

public interface PrizeService {

    int addPrizeToPromotion(Prize prize);

    void deletePrizeFromPromotion(int prizeId);


}
