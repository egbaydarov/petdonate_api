package hse.projectx.petdonate_api.model;


import lombok.Data;

@Data
public class Shelter {
    Long id;
    String name;
    Address location;
    String url;
    String email;
    Phone phone_number;
    String[] pictures;
    Invoice account;
}
