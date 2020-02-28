package hse.projectx.petdonate_api.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shelter")
@Data
public class Shelter {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "url")
    private String url;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "pictures", columnDefinition = "text[]")
    @Type(type = "hse.projectx.petdonate_api.utils.GenericArrayUserType")
    private String[] pictures;
    @Column(name = "account")
    private String account;
}
