CREATE TABLE time_slots
(
    time_slot_id   SERIAL PRIMARY KEY,
    time_slot_date date NOT NULL
);

CREATE TABLE sessions
(
    session_id          SERIAL PRIMARY KEY,
    session_name        varchar(80)   NOT NULL,
    session_description varchar(1024) NOT NULL,
    session_length      integer       NOT NULL
);

CREATE TABLE session_schedule
(
    schedule_id  SERIAL PRIMARY KEY,
    time_slot_id integer     NOT NULL REFERENCES time_slots (time_slot_id),
    session_id   integer     NOT NULL REFERENCES sessions (session_id),
    room         varchar(30) NOT NULL
);

CREATE TABLE speakers
(
    speaker_id  SERIAL PRIMARY KEY,
    first_name  varchar(30)   NOT NULL,
    last_name   varchar(30)   NOT NULL,
    title       varchar(40)   NOT NULL,
    company     varchar(50)   NOT NULL,
    speaker_bio varchar(2000) NOT NULL
);

CREATE TABLE session_speakers
(
    session_id integer NOT NULL REFERENCES sessions (session_id),
    speaker_id integer NOT NULL REFERENCES speakers (speaker_id)
);
