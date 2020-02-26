package hse.projectx.petdonate_api.controller;


import hse.projectx.petdonate_api.google.GoogleAuthenticator;
import hse.projectx.petdonate_api.model.Pet;
import hse.projectx.petdonate_api.repository.PetRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class PetController {

    private PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @GetMapping("/pets/{userId}/{token}")
    public List<Pet> getPetById(@PathVariable String userId,
                          @PathVariable String token) throws GeneralSecurityException, IOException {
        GoogleAuthenticator auth = new GoogleAuthenticator(token);
        GoogleIdToken.Payload payload = auth.getPayload();
        if (payload != null)
        {
            return petRepository.getPetById(userId);
        }
        return null;
    }



    @PostMapping("/pets/{token}")
    public Pet createPet(@PathVariable String token,
                         @Valid @RequestBody Pet pet) throws GeneralSecurityException, IOException {
        GoogleAuthenticator auth = new GoogleAuthenticator(token);
        GoogleIdToken.Payload payload = auth.getPayload();
        if (payload != null)
        {
            return petRepository.save(pet);
        }
        return null;
    }

//    @DeleteMapping("/pets/{token}")
//    public ResponseEntity<?> deletePet(@PathVariable String id,
//                                            @PathVariable String token) {
//        return petRepository.findById(id)
//                .map(pet -> {
//                    petRepository.delete(pet);
//                    return ResponseEntity.ok().build();
//                }).orElseThrow(() -> new ResourceNotFoundException("Pet not found with id " + id));
//    }
}
