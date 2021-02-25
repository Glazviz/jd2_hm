package it.academy.main;

import it.academy.load.PassportLoader;
import it.academy.load.PersonLoader;
import it.academy.load.EmailLoader;
import it.academy.pojo.Address;
import it.academy.pojo.Email;
import it.academy.pojo.Passport;
import it.academy.pojo.Person;
import java.sql.Date;

public class Main {

    public static void main(String[] args)  {

        Address address = new Address("Sadovaya", "Minsk", "200000");
        Person person1 = new Person(null, 25, "Maria", "Ivanova", address);
        Person person2 = new Person(null, 27, "Ivan", "Ivanov", address);
        Person person3 = new Person(null, 1, "Igor", "Ivanov", address);
        Person person4 = new Person(null, 3, "Alex", "Ivanov", new Address("Pushkina", "Pinsk", "225765"));
        PersonLoader personLoader = new PersonLoader();
        personLoader.savePerson(person1);
        personLoader.savePerson(person2);
        personLoader.savePerson(person3);
        personLoader.savePerson(person4);

        personLoader.deletePerson(person3.getId());

        personLoader.changeAge(person1.getId(), 20);
        personLoader.changeName(person1.getId(), "Sofia");
        personLoader.changeSurname(person1.getId(), "Smirnov");


        PassportLoader passportLoader = new PassportLoader();
        Passport passport1 = new Passport("AB1234567", Date.valueOf("2010-01-01"), Date.valueOf("2025-01-01"), Date.valueOf("2021-01-27"));
        Passport passport2 = new Passport("AB7894561", Date.valueOf("2010-01-03"), Date.valueOf("2025-01-04"), Date.valueOf("2021-01-28"));

        passportLoader.savePassword(passport1);
        passportLoader.savePassword(passport2);


        Email email1 = new Email(null, "test1", "111");
        Email email2 = new Email(null, "test2", "222");
        EmailLoader emailLoader = new EmailLoader();
        emailLoader.saveEmail(email1);
        emailLoader.saveEmail(email2);

    }
}
