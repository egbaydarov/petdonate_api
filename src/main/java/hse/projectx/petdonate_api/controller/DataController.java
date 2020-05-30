package hse.projectx.petdonate_api.controller;

import hse.projectx.petdonate_api.exception.ResourceNotFoundException;
import hse.projectx.petdonate_api.google.GoogleAuthenticator;
import hse.projectx.petdonate_api.model.DataState;
import hse.projectx.petdonate_api.model.Pet;
import hse.projectx.petdonate_api.model.User;
import hse.projectx.petdonate_api.repository.PetRepository;
import hse.projectx.petdonate_api.repository.UserRepository;
import hse.projectx.petdonate_api.transfer.UserDataRequest;
import hse.projectx.petdonate_api.transfer.UserDataResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;

//TODO DECOMPOSE
@RestController
public class DataController {
    private UserRepository userRepository;
    private PetRepository petRepository;

    public DataController(UserRepository userRepository, PetRepository petRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    @GetMapping()
    public String test() {
        return "HELLO";
    }

    @GetMapping("/apiv1/data/{token}")
    public ResponseEntity<UserDataResponse> getUserData(@PathVariable String token) {
        User user;
        Pet pet;
        DataState state = new DataState();
        UserDataResponse response = null;
        try {
            GoogleAuthenticator authenticator = new GoogleAuthenticator(token);
            GoogleIdToken.Payload payload = authenticator.getPayload();

            if (payload != null) {
                user = userRepository.getUserById(payload.getSubject()).get(0);
                pet = petRepository.getPetById(payload.getSubject()).get(0);
                state.setCur_HP(pet.getHp());
                state.setCur_Mana(pet.getFood());
                state.setCur_Stamina(pet.getHappiness());
                state.setID(user.getId());
                state.setName(pet.getName());
                state.setSkin(pet.getColor());
                state.setType(pet.getType());
                state.setTransactions_count(user.getTransactionsCount());
                response = new UserDataResponse(state, LocalDateTime.now());
            } else
                throw new IOException("Invalid Token!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (GeneralSecurityException | IOException | IndexOutOfBoundsException e) {
            e.printStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/apiv1/data/{token}")
    public ResponseEntity<String> postUserData(@PathVariable String token,
                                               @Valid @RequestBody UserDataRequest request) {
        User user = new User();
        Pet pet = new Pet();
        try {
            GoogleAuthenticator authenticator = new GoogleAuthenticator(token);
            GoogleIdToken.Payload payload = authenticator.getPayload();
            DataState state = request.getState();
            if (payload != null) {
                user.setId(payload.getSubject());
                user.setEmail(payload.getEmail());
                user.setName((String) payload.get("name"));
                user.setPicUrl((String) payload.get("picture"));
                user.setLastVisit(LocalDateTime.now());
                user.setPetID(payload.getSubject());
                userRepository.save(user);

                if (petRepository.existsById(user.getId())) {
                    throw new IOException("User already registered!");
                }

                pet.setName(state.getName());
                pet.setHappiness(state.getCur_Stamina());
                pet.setHp(state.getCur_HP());
                pet.setFood(state.getCur_Mana());
                pet.setUserId(user.getId());
                pet.setColor(state.getSkin());
                pet.setType(state.getType());
                pet.setId(user.getId());
                petRepository.save(pet);
            } else
                return new ResponseEntity<String>("Google account not found", HttpStatus.MULTI_STATUS);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/apiv1/data/{token}")
    public ResponseEntity<String> putUserData(@PathVariable String token,
                                               @Valid @RequestBody UserDataRequest request) {
        GoogleAuthenticator auth = null;
        try {
            auth = new GoogleAuthenticator(token);
            GoogleIdToken.Payload payload = auth.getPayload();

            if (!userRepository.existsById(payload.getSubject()))
                throw new IOException("User Not Found");

            DataState state = request.getState();

            petRepository.findById(payload.getSubject())
                    .map(pet ->
                    {
                        pet.setName(state.getName());
                        pet.setHappiness(state.getCur_Stamina());
                        pet.setFood(state.getCur_Mana());
                        pet.setHp(state.getCur_HP());
                        pet.setColor(state.getSkin());
                        pet.setType(state.getType());
                        return petRepository.save(pet);
                    }).orElseThrow(() -> new ResourceNotFoundException("Pet not found with id " + state.getID()));

            userRepository.findById(payload.getSubject())
                    .map(user1 ->
                    {
                        user1.setEmail(payload.getEmail());
                        user1.setName((String) payload.get("name"));
                        user1.setPicUrl((String) payload.get("picture"));
                        user1.setLastVisit(LocalDateTime.now());
                        return userRepository.save(user1);
                    }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + state.getID()));
            return new ResponseEntity<>("Changes saved", HttpStatus.OK);
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
        }
    }
}
