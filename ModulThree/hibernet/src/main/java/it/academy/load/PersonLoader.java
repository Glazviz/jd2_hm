package it.academy.load;

import it.academy.pojo.Person;
import it.academy.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonLoader {
    HibernateUtil hibernateUtil = new HibernateUtil();
    final static Logger log = Logger.getLogger(PersonLoader.class);

    public void savePerson(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
            log.info("Person " + person + " was added in bd");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            log.error("Could not save the object " + e);
        } finally {
            session.close();
        }

    }

    public void deletePerson(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person personForDelete = session.get(Person.class, id);
            session.delete(personForDelete);
            tx.commit();
            log.info("Person with id " + id + " was deleted");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            log.error("Could not delete the object " + e);
        } finally {
            session.close();
        }
    }

    public Person findPerson(Integer id) {
        Session session = HibernateUtil.getSession();
        Person person = session.get(Person.class, id);
        session.close();
        if (person != null) {
            log.info("Person with id " + id + " was founded");
            return person;
        } else {
            log.info("Person with id " + id + " was not founded");
            return null;
        }
    }

    public void changeSurname(Integer id, String surname) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, id);
            person.setSurname(surname);
            session.flush();
            session.clear();
            tx.commit();
            log.info("Surname of person with id " + id + " was changed");

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            log.error("Could not change the surname " + e);
        } finally {
            session.close();
        }
    }

    public void changeName(Integer id, String name) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, id);
            person.setName(name);
            session.flush();
            session.clear();
            tx.commit();
            log.info("Name of person with id " + id + " was changed");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            log.error("Could not change the surname " + e);
        } finally {
            session.close();
        }
    }

    public void changeAge(Integer id, Integer age) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, id);
            person.setAge(age);
            session.flush();
            session.clear();
            tx.commit();
            log.info("Age of person with id " + id + " was changed");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            log.error("Could not change the surname " + e);
        } finally {
            session.close();
        }
    }
}







