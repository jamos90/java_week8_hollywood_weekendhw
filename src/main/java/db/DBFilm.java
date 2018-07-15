package db;

import models.Actor;
import models.Film;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBFilm {
    private static Transaction transaction;
    private static Session session;

    public static void addActors(Actor actor, Film film){
        film.addActor(actor);
        actor.addFilm(film);
        DBHelper.update(film);
    }
}

