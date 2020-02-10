package hse.projectx.petdonate_api.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usr")
@Data
public class User {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "picUrl")
    private String picUrl;
    @Column(name = "lastVisit")
    private LocalDateTime lastVisit;
    @Column(name = "petID")
    private String petID;
}
