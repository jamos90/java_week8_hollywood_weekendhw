package db;

import models.Actor;
import models.Film;
import models.Studio;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBStudio {

    private static Transaction transaction;
    private static Session session;

    public static List<Film> getStudiosActors(Studio studio){
        List<Film> films = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Film.class);
            cr.add(Restrictions.eq("studio", studio));
            films = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return films;
    }

    public static void addActorToStudio(Studio studio, Actor actor){
        studio.addActor(actor);
        actor.addStudio(studio);
        DBHelper.update(studio);
    }

    public static List<Actor> getStudiosActor(Studio studio){
        List<Actor> actors = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Actor.class);
            cr.createAlias("studios", "studio");
            cr.add(Restrictions.eq("studio.id",studio.getId()));
            actors = cr.list();
        } catch (HibernateException e){
        }
        finally {
            session.close();
        }
        return actors;
    }
}
