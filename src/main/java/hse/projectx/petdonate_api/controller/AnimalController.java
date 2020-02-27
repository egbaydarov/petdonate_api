package hse.projectx.petdonate_api.controller;

import hse.projectx.petdonate_api.model.Animal;
import hse.projectx.petdonate_api.repository.AnimalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AnimalController {
    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @PostMapping("/apiv1/animals")
    public ResponseEntity addAnimalToShelter(@Valid @RequestBody Animal animal) {
        animalRepository.save(animal);
        return ResponseEntity.ok().body(animal);
    }

    @GetMapping("/apiv1/animals/{shelterId}")
    public ResponseEntity getAnimalsFromShelter(@PathVariable String shelterId) {
        List<Animal> res = animalRepository.GetAnimalByShelterId(shelterId);
        if (res != null)
            return ResponseEntity.ok().body(res);
        else
            return ResponseEntity.noContent().build();
    }
}
