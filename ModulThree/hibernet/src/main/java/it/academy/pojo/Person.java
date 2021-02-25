package it.academy.pojo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "T_PERSON")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Person {

    @Id
    @GeneratedValue(generator = "increment-generator")
    @GenericGenerator(name = "increment-generator", strategy = "increment")

    private Integer id;

    private Integer age;

    private String name;

    private String surname;

    private Address address;
}
