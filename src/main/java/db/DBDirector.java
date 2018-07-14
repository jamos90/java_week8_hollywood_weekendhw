package db;

import models.Director;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBDirector {

   private static Transaction transaction;
    private static Session session;

    public static List<Film> getAllFilms(Director director){
        List<Film> films = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Film.class);
            cr.add(Restrictions.eq("director", director));
            films = cr.list();
        }
        catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return  films;
    }
}
