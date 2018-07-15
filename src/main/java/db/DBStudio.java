package db;

import models.Actor;
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

    public static List<Actor> getStudiosActors(Studio studio){
        List<Actor> actors = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Actor.class);
            cr.add(Restrictions.eq("studios", studio));
            actors = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return actors;
    }

    public static void addActorToStudio(Studio studio, Actor actor){
        studio.addActor(actor);
        actor.addStudio(studio);
        DBHelper.update(studio);
    }
}
