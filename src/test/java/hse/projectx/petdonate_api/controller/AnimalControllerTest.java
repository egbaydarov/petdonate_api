package hse.projectx.petdonate_api.controller;

import hse.projectx.petdonate_api.model.Animal;
import hse.projectx.petdonate_api.repository.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AnimalControllerTest {

    @Autowired
    private AnimalRepository animalRepository;

    Animal testModel = new Animal();

    @BeforeEach
    void setUp() {
    }

    @Test
    void addAnimalToShelter() {
    }

    @Test
    void getAnimalsFromShelter() {
    }

    @Test
    void deleteAnimal() {
    }
}