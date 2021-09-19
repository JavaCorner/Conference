package com.ab.repository;

import com.ab.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
@Repository("speakerRepository")
public class AnnotatedHibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Autowired
    private Calendar calendar;

    //spring expression language
    @Value("#{ T(java.lang.Math).random() * 100 }")
    private double seedNum;

    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("Arpit");
        speaker.setLastName("Bhardwaj");
        speaker.setSeedNum(seedNum);

        System.out.println("Calendar : " + calendar.getTime());

        speakers.add(speaker);
        return speakers;
    }
}
