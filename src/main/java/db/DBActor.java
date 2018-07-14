package db;

import models.Actor;
import models.Award;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBActor {

    private static Transaction transaction;
    private static Session session;

    public static void addActorToAward(Actor actor, Award award){
        award.addActor(actor);
        actor.addAawrd(award);
        DBHelper.update(actor);
    }

}
