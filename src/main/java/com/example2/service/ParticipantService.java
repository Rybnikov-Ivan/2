package com.example2.service;

import com.example2.model.Participant;

public interface ParticipantService {

    int addParticipantToPromotion(int id, Participant participant);

    void deleteParticipantFromPromotion(int participantId);
}
