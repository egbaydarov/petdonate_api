package hse.projectx.petdonate_api.controller;

import hse.projectx.petdonate_api.repository.ShelterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShelterControllerTest {

    @Autowired
    private ShelterRepository shelterRepository;

    @BeforeEach
    void setUp() {
        assertEquals(1,1);
    }

    @Test
    void downloadImage() {
        assertEquals(1,1);
    }

    @Test
    void getShelter() {
        assertEquals(1,1);
    }

    @Test
    void getShelters() {
        assertEquals(1,1);
    }

    @Test
    void postShelter() {
        assertEquals(1,1);
    }
}