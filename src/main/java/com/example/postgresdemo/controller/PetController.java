package com.example.postgresdemo.controller;


import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.google.GoogleAuthenticator;
import com.example.postgresdemo.model.Pet;
import com.example.postgresdemo.repository.PetRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class PetController {

    private PetRepository petRepository;

    @GetMapping("test")
    public String test()
    {
        return "HELLO";
    }

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
