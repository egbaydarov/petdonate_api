package hse.projectx.petdonate_api.controller;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import hse.projectx.petdonate_api.exception.ResourceNotFoundException;
import hse.projectx.petdonate_api.google.GoogleAuthenticator;
import hse.projectx.petdonate_api.model.Pet;
import hse.projectx.petdonate_api.model.Shelter;
import hse.projectx.petdonate_api.repository.PetRepository;
import hse.projectx.petdonate_api.repository.ShelterRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class ShelterController {

    private ShelterRepository shelterRepository;

    public ShelterController(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    @GetMapping("apiv1/shelter/{id}/image/{token}")
    public ResponseEntity downloadImage(@PathVariable String id, @PathVariable String token) {
        GoogleAuthenticator authenticator = null;
        try {
//            authenticator = new GoogleAuthenticator(token);
//            GoogleIdToken.Payload payload = authenticator.getPayload();
//            if (payload == null)
//                throw new ResourceNotFoundException("Bad TOKEN");
            Path path = Paths.get("target/classes/images/" + id + ".jpg");
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

    @GetMapping("apiv1/shelter/{id}/{token}")
    public ResponseEntity getShelter(@PathVariable Long id, @PathVariable String token) {
        Shelter res = null;
        GoogleAuthenticator authenticator = null;
        //            authenticator = new GoogleAuthenticator(token);
//            GoogleIdToken.Payload payload = authenticator.getPayload();
//            if (payload == null)
//                throw new ResourceNotFoundException("Bad TOKEN");
        res = shelterRepository.GetShelterById(id).get(0);
        return ResponseEntity.ok().body(res);
    }

    @CrossOrigin(origins = "https://demopet.herokuapp.com")
    @GetMapping("apiv1/shelters/{token}")
    public ResponseEntity<List<Shelter>> getShelters(@PathVariable String token) {
        List<Shelter> shelters = null;
        GoogleAuthenticator authenticator = null;
//            authenticator = new GoogleAuthenticator(token);
//            GoogleIdToken.Payload payload = authenticator.getPayload();
//            if (payload == null)
//                throw new ResourceNotFoundException("Bad TOKEN");
        shelters = shelterRepository.findAll();
        return ResponseEntity.ok().body(shelters);
    }

    @PostMapping("apiv1/shelters/{token}")
    public ResponseEntity postShelter(@PathVariable String token,
                                      @RequestParam("account") String account,
                                      @RequestParam("phone_number") String number,
                                      @RequestParam("email") String email,
                                      @RequestParam("url") String url,
                                      @RequestParam("location") String location,
                                      @RequestParam("name") String name,
                                      @RequestParam("picture") String picture
    ) {
        Shelter shelter = new Shelter();
        shelter.setPhone_number(number);
        shelter.setAccount(account);
        shelter.setEmail(email);
        shelter.setName(name);
        shelter.setUrl(url);
        shelter.setLocation(location);
        shelter.setPicture(picture);
        Long id = shelterRepository.save(shelter).getId();

        return ResponseEntity.ok().body(id);
    }

    @DeleteMapping("/apiv1/shelters/{shelterId}")
    public ResponseEntity deleteShelter(@PathVariable Long shelterId) {
        if (shelterRepository.existsById(shelterId)) {
            shelterRepository.deleteById(shelterId);
            return ResponseEntity.ok().body("shelter: " + shelterId + " deleted");
        } else
            return ResponseEntity.notFound().build();
    }
}

