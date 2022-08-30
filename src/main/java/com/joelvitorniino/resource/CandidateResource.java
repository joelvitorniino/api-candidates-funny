package com.joelvitorniino.resource;

import com.joelvitorniino.dto.CandidateDTO;
import com.joelvitorniino.model.Candidate;
import com.joelvitorniino.service.CandidateService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/candidate")
public class CandidateResource {
    @Autowired
    CandidateService service;

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> findAll() {
        List<Candidate> list = service.findAll();
        List<CandidateDTO> listDto = list.stream().map(x -> new CandidateDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CandidateDTO objDto) {
        Candidate obj = service.fromDTO(objDto);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/random")
    public ResponseEntity<String> randomCandidate() {
        return ResponseEntity.ok().body(service.randomCandidate());
    }
}
