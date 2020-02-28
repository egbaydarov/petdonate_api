package hse.projectx.petdonate_api.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animals")
@Data
public class Animal {
    @Id
    String id;
    @Column(name = "shelter_id")
    String shelter_id;
    @Column(name = "type")
    String type;
    @Column(name = "name")
    String name;
    @Column(name = "isBoy")
    Boolean isBoy;
    @Type(type = "hse.projectx.petdonate_api.utils.GenericArrayUserType")
    @Column(name = "pictures", columnDefinition = "text[]")
    String[] pictures;
}
