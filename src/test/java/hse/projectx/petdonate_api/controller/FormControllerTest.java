package hse.projectx.petdonate_api.controller;

import hse.projectx.petdonate_api.repository.AdoptFormRepository;
import hse.projectx.petdonate_api.repository.HelpFormRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class FormControllerTest {

    @Autowired
    private AdoptFormRepository adoptFormRepository;
    @Autowired
    private HelpFormRepository helpFormRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void postAdoptForm() {
    }

    @Test
    void postHelpForm() {
    }

    @Test
    void getAdoptFormByID() {
    }

    @Test
    void getHelpFormByID() {
    }
}