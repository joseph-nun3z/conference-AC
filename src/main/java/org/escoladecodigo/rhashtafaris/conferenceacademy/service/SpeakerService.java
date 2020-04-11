package org.escoladecodigo.rhashtafaris.conferenceacademy.service;

import org.escoladecodigo.rhashtafaris.conferenceacademy.exception.SpeakerNotFoundException;
import org.escoladecodigo.rhashtafaris.conferenceacademy.model.Speaker;

import java.util.List;

public interface SpeakerService {

    Speaker get(Integer id) throws SpeakerNotFoundException;

    Speaker save(Speaker speaker);

    void delete(Speaker speaker);

    List<Speaker> listSpeakers();

    Speaker update(Speaker speaker) throws SpeakerNotFoundException;
}
