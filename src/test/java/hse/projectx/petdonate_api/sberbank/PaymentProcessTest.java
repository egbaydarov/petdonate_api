package hse.projectx.petdonate_api.sberbank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessTest {

    PaymentData data = new PaymentData();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void post() {
        PaymentProcess proc = new PaymentProcess();
        try {
            proc.post();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}