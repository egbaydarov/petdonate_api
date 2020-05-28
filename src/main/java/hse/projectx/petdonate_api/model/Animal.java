package hse.projectx.petdonate_api.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "animals")
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "shelter_id")
    Long shelter_id;
    @Column(name = "type")
            
    String type;

    @Size(min=2, max=12)
    @Column(name = "name")
    String name;

    @Size(min=3, max=256)
    @Column(name = "appear")
    String appear;

    @Size(min=3, max=256)
    @Column(name = "behavior")
    String behavior;
    @Column(name = "gender")
    String gender;
//    @Type(type = "hse.projectx.petdonate_api.utils.GenericArrayUserType")
//    @Column(name = "pictures", columnDefinition = "text[]")
//    String[] pictures;
}
