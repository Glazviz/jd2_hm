package it.academy.pojo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Email")
@NoArgsConstructor
@AllArgsConstructor

public class Email {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String emailId;

    private String email;

    private String password;

}
