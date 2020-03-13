package hse.projectx.petdonate_api.controller;

import hse.projectx.petdonate_api.repository.PetRepository;
import hse.projectx.petdonate_api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DataControllerTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PetRepository petRepository;

    @Test
    void getUserData() {
    }

    @Test
    void postUserData() {
    }

    @Test
    void testPostUserData() {
    }
}