package hse.projectx.petdonate_api.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "adoptforms")
@Data
public class AdoptForm
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "shelter_id")
    private String shelter_id;
    @Column(name = "animal_id")
    private String animal_id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "extra")
    private String extra;
}