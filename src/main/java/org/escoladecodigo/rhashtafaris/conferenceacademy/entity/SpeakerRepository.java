package org.escoladecodigo.rhashtafaris.conferenceacademy.entity;

import org.escoladecodigo.rhashtafaris.conferenceacademy.model.Speaker;
import org.springframework.data.repository.CrudRepository;

public interface SpeakerRepository extends CrudRepository<Speaker, Integer> {
}