package com.ab.repository;

import com.ab.model.Speaker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("Arpit");
        speaker.setLastName("Bhardwaj");

        speakers.add(speaker);
        return speakers;
    }
}
