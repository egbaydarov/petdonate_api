package hse.projectx.petdonate_api.controller;

import hse.projectx.petdonate_api.model.AdoptForm;
import hse.projectx.petdonate_api.model.HelpForm;
import hse.projectx.petdonate_api.repository.AdoptFormRepository;
import hse.projectx.petdonate_api.repository.HelpFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FormController {
    private AdoptFormRepository adoptFormRepository;
    private HelpFormRepository helpFormRepository;

    public FormController(AdoptFormRepository adoptFormRepository, HelpFormRepository helpFormRepository) {
        this.adoptFormRepository = adoptFormRepository;
        this.helpFormRepository = helpFormRepository;
    }

    @PostMapping("/apiv1/adopt")
    public ResponseEntity postAdoptForm(@Valid @RequestBody AdoptForm form) {
        adoptFormRepository.save(form);
        return ResponseEntity.ok().body(form);
    }

    @PostMapping("/apiv1/help")
    public ResponseEntity postHelpForm(@Valid @RequestBody HelpForm form) {
        helpFormRepository.save(form);
        return ResponseEntity.ok().body(form);
    }

    @GetMapping("/apiv1/adopt/")
    public ResponseEntity getAdoptFormByID() {
        return ResponseEntity.ok().body(adoptFormRepository.findAll());
    }

    @GetMapping("/apiv1/help/")
    public ResponseEntity getHelpFormByID() {
        return ResponseEntity.ok().body(helpFormRepository.findAll());
    }
}
