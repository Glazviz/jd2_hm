package it.academy.load;

import it.academy.pojo.Passport;
import it.academy.pojo.Person;
import it.academy.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PassportLoader {
    HibernateUtil hibernateUtil = new HibernateUtil();
    final static Logger log = Logger.getLogger(PassportLoader.class);


    public void savePassword(Passport passport) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(passport);
            tx.commit();
            log.info("Passport " + passport + " was added in bd");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            log.error("Could not save the object " + e);
        } finally {
            session.close();
        }

    }

    public void deletePassport(String num) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Passport passportForDelete = session.get(Passport.class, num);
            session.delete(passportForDelete);
            tx.commit();
            log.info("Passport with id " + num + " was deleted");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            log.error("Could not delete the object " + e);
        } finally {
            session.close();
        }
    }


}
