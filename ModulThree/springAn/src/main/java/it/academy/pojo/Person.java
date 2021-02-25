package it.academy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@PropertySource("classpath:person.properties")
public class Person {

    private Integer id;

    @Value("${person.age}")
    private Integer age;

    @Value("${person.name}")
    private String name;

    @Value("${person.surname}")
    private String surname;

    @Autowired(required = false)
    @Qualifier("firstAddress")
    private Address address;

    @Autowired(required = false)
    @Qualifier("Email")
    private Emaill email;

}
