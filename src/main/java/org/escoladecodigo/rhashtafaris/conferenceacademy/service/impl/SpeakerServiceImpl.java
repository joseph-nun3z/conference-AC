package org.escoladecodigo.rhashtafaris.conferenceacademy.service.impl;

import org.escoladecodigo.rhashtafaris.conferenceacademy.exception.ConferenceAPIException;
import org.escoladecodigo.rhashtafaris.conferenceacademy.repository.SpeakerRepository;
import org.escoladecodigo.rhashtafaris.conferenceacademy.exception.SpeakerNotFoundException;
import org.escoladecodigo.rhashtafaris.conferenceacademy.model.Speaker;
import org.escoladecodigo.rhashtafaris.conferenceacademy.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = ConferenceAPIException.class)
public class SpeakerServiceImpl implements SpeakerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpeakerService.class);

    @Autowired
    private SpeakerRepository repository;


    @Override
    public Speaker get(Integer id) throws SpeakerNotFoundException {

        Optional<Speaker> speaker = repository.findById(id);

        if (!speaker.isPresent()){
            LOGGER.error("Speaker not found");
            throw new SpeakerNotFoundException();
        }

        return speaker.get();
    }

    @Override
    public void delete(Speaker speaker) {
        repository.delete(speaker);
    }

    @Override
    public List<Speaker> listSpeakers() {

        List<Speaker> speakerList = new ArrayList<>();

        repository.findAll().forEach(speakerList::add);

        return speakerList;
    }

    @Override
    public Speaker save(Speaker speaker) {
        Speaker savedSpeaker = repository.save(speaker);

        LOGGER.info("Speaker saved successfully with id: " + speaker.getSpeakerId());

        return savedSpeaker;
    }


    @Override
    public Speaker update(Speaker speaker) throws SpeakerNotFoundException {

        Optional<Speaker> savedSpeaker = repository.findById(speaker.getSpeakerId());

        if (!savedSpeaker.isPresent()){
            throw new SpeakerNotFoundException();
        }

        repository.save(speaker);

        LOGGER.info("Speaker saved successfully with id: " + speaker.getSpeakerId());

        return savedSpeaker.get();
    }
}
