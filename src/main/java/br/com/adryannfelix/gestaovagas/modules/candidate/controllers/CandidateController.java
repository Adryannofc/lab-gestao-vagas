package br.com.adryannfelix.gestaovagas.modules.candidate.controllers;

import br.com.adryannfelix.gestaovagas.exceptions.UserFoundException;
import br.com.adryannfelix.gestaovagas.modules.candidate.CandidateEntity;
import br.com.adryannfelix.gestaovagas.modules.candidate.CandidateRepository;
import br.com.adryannfelix.gestaovagas.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
           var result =  this.createCandidateUseCase.execute(candidateEntity);
           return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
