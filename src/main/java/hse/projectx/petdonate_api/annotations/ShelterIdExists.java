package hse.projectx.petdonate_api.annotations;


import hse.projectx.petdonate_api.model.Animal;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ShelterIdExists implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Animal.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    }
}
