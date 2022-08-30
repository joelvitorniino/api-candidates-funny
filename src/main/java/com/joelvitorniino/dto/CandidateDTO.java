package com.joelvitorniino.dto;

import com.joelvitorniino.model.Candidate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class CandidateDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String word;

    public CandidateDTO() {
    }

    public CandidateDTO(Candidate obj) {
        this.id = obj.getId();
        this.word = obj.getWord();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}