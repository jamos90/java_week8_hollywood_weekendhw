import db.DBHelper;
import models.Actor;

public class Runner {


    public static void main(String[] args) {

        Actor actor = new Actor("James", 4555);
        DBHelper.save(actor);
    }
}


