package hse.projectx.petdonate_api.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "shelter")
@Data
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Size(min=3, max=50)
    @Column(name = "name", unique=true)
    private String name;

    @Size(min=3, max=100)
    @Column(name = "location")
    private String location;

    @Size(min=3, max=40)
    @Column(name = "url")
    private String url;

    @Size(min=3, max=50)
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "(\\+79|0)[0-9]{9}")
    @Column(name = "phone_number")
    private String phone_number;

//    @Column(name = "pictures", columnDefinition = "text[]")
//    @Type(type = "hse.projectx.petdonate_api.utils.GenericArrayUserType")
//    private String[] pictures;

    @Size(min=3, max=20)
    @Column(name = "account")
    private String account;
}
