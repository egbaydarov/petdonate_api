package hse.projectx.petdonate_api.model;

import lombok.Data;

@Data
public class Animal {
    Long id;
    Long shelter_id;
    String type;
    String name;
    Boolean isBoy;
    String[] pictures;
}
