package org.escoladecodigo.rhashtafaris.conferenceacademy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speaker_id", columnDefinition = "int")
    private Integer speakerId;

    @Column(name = "first_name", columnDefinition = "varchar(100)", nullable = false)
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(100)", nullable = false)
    private String lastName;

    @Column(name = "title", columnDefinition = "varchar(100)")
    private String title;

    @Column(name = "company", columnDefinition = "varchar(100)")
    private String company;

    @Column(name = "speaker_bio", columnDefinition = "varchar(100)")
    private String speakerBio;

    @ManyToMany(mappedBy = "speakers")
    private List<Session> sessions;

}
