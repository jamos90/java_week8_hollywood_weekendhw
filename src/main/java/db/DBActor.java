package db;

import models.Actor;
import models.Award;
import models.Film;
import models.Genre;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBActor {

    private static Transaction transaction;
    private static Session session;

    public static void addActorToAward(Actor actor, Award award){
        award.addActor(actor);
        actor.addAawrd(award);
        DBHelper.update(actor);
    }


    public static List<Film> getAllActorsFilms(Actor actor){
        List<Film> films = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Film.class);
            cr.createAlias("actors","actor" );
            cr.add(Restrictions.eq("actor.id",actor.getId()));
            films = cr.list();
        }
        catch (HibernateException e){

        } finally {
            session.close();
        }
        return films;
    }

    public static List<Film> getAllActorsFilmsGenre(Actor actor, Genre genre){
        List<Film> films = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Film.class);
            cr.createAlias("actors","actor" );
            cr.add(Restrictions.eq("actor.id",actor.getId()));
            cr.add(Restrictions.eq("genre",genre));
            films = cr.list();
        }
        catch (HibernateException e){

        } finally {
            session.close();
        }
        return films;
    }





}
