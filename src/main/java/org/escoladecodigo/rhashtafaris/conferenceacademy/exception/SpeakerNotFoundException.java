package org.escoladecodigo.rhashtafaris.conferenceacademy.exception;

import org.escoladecodigo.rhashtafaris.conferenceacademy.util.ErrorMessages;

public class SpeakerNotFoundException extends ConferenceAPIException {

    public SpeakerNotFoundException() {
        super(ErrorMessages.SPEAKER_NOT_FOUND);
    }
}
