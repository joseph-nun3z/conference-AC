package org.escoladecodigo.rhashtafaris.conferenceacademy.controller;

import org.escoladecodigo.rhashtafaris.conferenceacademy.dto.SpeakerDto;
import org.escoladecodigo.rhashtafaris.conferenceacademy.exception.SpeakerNotFoundException;
import org.escoladecodigo.rhashtafaris.conferenceacademy.model.Speaker;
import org.escoladecodigo.rhashtafaris.conferenceacademy.service.SpeakerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/conference/speaker")
@RestController
public class SpeakerController {


    @Autowired
    private SpeakerService speakerService;

    private static final ModelMapper MAPPER = new ModelMapper();


    @GetMapping("/{id}")
    public ResponseEntity<SpeakerDto> get(@PathVariable Integer id) throws SpeakerNotFoundException {
        SpeakerDto speaker = MAPPER.map(speakerService.get(id), SpeakerDto.class);

        return new ResponseEntity<>(speaker, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody @Valid SpeakerDto speakerDto){

        Speaker savedSpeaker = speakerService.save(MAPPER.map(speakerDto, Speaker.class));

        return new ResponseEntity<>(savedSpeaker.getSpeakerId(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> update(@PathVariable Integer id, @RequestBody @Valid SpeakerDto speakerDto) throws SpeakerNotFoundException {

        Speaker speaker = MAPPER.map(speakerDto, Speaker.class);
        speaker.setSpeakerId(id);
        speakerService.update(speaker);

        return new ResponseEntity<>(speaker.getSpeakerId(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws SpeakerNotFoundException {
        Speaker speaker = speakerService.get(id);
        speakerService.delete(speaker);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
