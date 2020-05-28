package hse.projectx.petdonate_api.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "user_id")
    String user_id;
    @Column(name = "micros")
    Long micros;
    @Column(name = "shelter_id")
    Long shelter_id;
}
