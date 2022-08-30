package com.joelvitorniino.service;

import com.joelvitorniino.dto.CandidateDTO;
import com.joelvitorniino.model.Candidate;
import com.joelvitorniino.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository repository;

    public List<Candidate> findAll() {
        return repository.findAll();
    }

    public String randomCandidate() {
        Random random = new Random();
        String randomElement = null;

        int numberOfElements = 2;

        for(int i = 0; i < numberOfElements; i++) {
            int randomIndex = random.nextInt(findAll().size());
            randomElement = String.valueOf(findAll().get(randomIndex));

            findAll().remove(randomIndex);
        }

        return randomElement;
    }

    public Candidate insert(Candidate obj) {
        return repository.save(obj);
    }

    public Candidate fromDTO(CandidateDTO objDto) {
        return new Candidate(objDto.getId(), objDto.getWord());
    }
}
