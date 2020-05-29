package hse.projectx.petdonate_api.controller;

import hse.projectx.petdonate_api.google.GoogleAuthenticator;
import hse.projectx.petdonate_api.model.Animal;
import hse.projectx.petdonate_api.repository.AnimalRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class AnimalController {
    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }



    @GetMapping("apiv1/animal/{id}/image/{token}")
    public ResponseEntity downloadImage(@PathVariable String id, @PathVariable String token) {
        GoogleAuthenticator authenticator = null;
        try {
//            authenticator = new GoogleAuthenticator(token);
//            GoogleIdToken.Payload payload = authenticator.getPayload();
//            if (payload == null)
//                throw new ResourceNotFoundException("Bad TOKEN");
            Path path = Paths.get("target/classes/images/animals/" + id + ".jpg");
            Resource resource = null;
            resource = new UrlResource(path.toUri());
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("image/jpeg"))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/apiv1/animals")
    public ResponseEntity addAnimalToShelter(@RequestParam("shelter_id") Long shelter_id,
                                             @RequestParam("gender") String gender,
                                             @RequestParam("behavior") String behaviour,
                                             @RequestParam("name") String name,
                                             @RequestParam("appear") String appear,
                                             @RequestParam("type") String type,
                                             @RequestParam("picture") String picture) {

        if (picture.isEmpty()) {
            return ResponseEntity.badRequest().body("Empty file. Can't upload image");
        }
        Animal animal = new Animal();
        animal.setName(name);
        animal.setGender(gender);
        animal.setAppear(appear);
        animal.setBehavior(behaviour);
        animal.setShelter_id(shelter_id);
        animal.setType(type);
        animal.setPicture(picture);

        animalRepository.save(animal);
        return ResponseEntity.ok().body(animal);
    }

    @GetMapping("/apiv1/animals/{shelterId}")
    public ResponseEntity getAnimalsFromShelter(@PathVariable Long shelterId) {
        List<Animal> res = animalRepository.GetAnimalByShelterId(shelterId);
        if (res != null)
            return ResponseEntity.ok().body(res);
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/apiv1/animals/")
    public ResponseEntity getAllAnimals() {
        List<Animal> res = animalRepository.getAllIds();
        if (res != null)
            return ResponseEntity.ok().body(res);
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/apiv1/animals/{animalID}")
    public ResponseEntity deleteAnimal(@PathVariable Long animalID)
    {
        if(animalRepository.existsById(animalID))
        {
            animalRepository.deleteById(animalID);
            return ResponseEntity.ok().body("animal: " + animalID + " deleted");
        }
        else
            return ResponseEntity.notFound().build();
    }
}
