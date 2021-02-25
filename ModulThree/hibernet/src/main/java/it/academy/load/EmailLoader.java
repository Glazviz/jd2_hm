package it.academy.load;

import it.academy.pojo.Email;
import it.academy.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class EmailLoader {
    HibernateUtil hibernateUtil = new HibernateUtil();
    final static Logger log = Logger.getLogger(EmailLoader.class);


    public void saveEmail(Email email) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(email);
            tx.commit();
            log.info("Email " + email + " was added in bd");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            log.error("Could not save the object " + e);
        } finally {
            session.close();
        }

    }

    public void deleteEmail(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Email emailForDelete = session.get(Email.class, id);
            session.delete(emailForDelete);
            tx.commit();
            log.info("Email with id " + id + " was deleted");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            log.error("Could not delete the object " + e);
        } finally {
            session.close();
        }
    }
}
