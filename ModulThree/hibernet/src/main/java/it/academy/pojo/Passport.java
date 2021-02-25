package it.academy.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "PASSPORT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    @Column(name = "T_NUMBER")
    private String passportNumber;

    @Column(name = "T_ISSUED")
    private Date issuedDate;

    @Column(name = "T_EXPIRYDATE")
    @Access(AccessType.FIELD)
    public Date expiryDate;

    @Transient
    @Access(AccessType.PROPERTY)
    public Date loginTime;

}




