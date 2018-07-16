package db;

import models.Actor;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFilm {
    private static Transaction transaction;
    private static Session session;

    public static void addActors(Actor actor, Film film){
        film.addActor(actor);
        actor.addFilm(film);
        DBHelper.update(film);
    }

    public static List<Actor> getFilmsActors(Film film){
        List<Actor> actors = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Actor.class);
            cr.createAlias("films","film");
            cr.add(Restrictions.eq("film.id", film.getId()));
            actors = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return actors;
    }

}

