package org.escoladecodigo.rhashtafaris.conferenceacademy.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SpeakerDto {

    @NotBlank(message = "First name mandatory")
    private String firstName;

    @NotBlank(message = "Last name mandatory")
    private String lastName;

    @NotBlank(message = "Title mandatory")
    private String title;

    @NotBlank(message = "Company mandatory")
    private String company;

    @NotBlank(message = "Bio mandatory")
    private String speakerBio;

}
