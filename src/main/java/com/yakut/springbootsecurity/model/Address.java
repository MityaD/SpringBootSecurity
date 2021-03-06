package com.yakut.springbootsecurity.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_address")
    private Long idAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address(String city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }
}
