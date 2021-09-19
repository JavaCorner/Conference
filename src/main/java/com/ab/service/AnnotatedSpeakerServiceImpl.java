package com.ab.service;

import com.ab.model.Speaker;
import com.ab.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */

@Service("speakerService")
public class AnnotatedSpeakerServiceImpl implements SpeakerService {
    //This is the hardcoded injection need to do if we don't use Spring
    //private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();

    private SpeakerRepository repository;

    public AnnotatedSpeakerServiceImpl() {
        System.out.println("SpeakerServiceImpl no arg constructor");
    }

    //this constructor will be used for repository injection via java config
    @Autowired
    public AnnotatedSpeakerServiceImpl(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl repository constructor");
        this.repository = repository;
    }
    @PostConstruct
    public void initialize(){
        System.out.println("We are called after the constructors");
    }
    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }

    //this setter will be used for repository injection via java config
    //@Autowired
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl setter");
        this.repository = repository;
    }
}
