package it.academy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @Column(name = "STREET")
    private String street;

    @Column(name = "T_CITY")
    private String city;

    @Column(name = "T_POSTALCODE")
    private String postalCode;
}
