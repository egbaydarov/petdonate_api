package hse.projectx.petdonate_api.model;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "helpforms")
@Data
public class HelpForm {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "shelter_id")
    private Long shelter_id;

    @Size(min=3, max=100)
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "(\\+79)[0-9]{9}")
    @Column(name = "phone")
    private String phone;

    @Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @Column(name = "email")
    private String email;

    @Column(name = "date")
    @Pattern(regexp = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.((?:19|20)\\d{2})\\s*$")
    private String date;

    @Size(min=3, max=256)
    @Column(name = "extra")
    private String extra;
}
