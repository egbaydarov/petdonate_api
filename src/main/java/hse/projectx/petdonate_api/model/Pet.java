package hse.projectx.petdonate_api.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
@Table(name = "pet")
@Data
public class Pet {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "hp")
    private Integer hp;
    @Column(name = "food")
    private Integer food;
    @Column(name = "happiness")
    private Integer happiness;
    @Column(name = "userid")
    private String userId;
    @Column(name = "color")
    private Integer color;
    @Column(name = "type")
    private String type;
}
