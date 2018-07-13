import db.DBHelper;
import models.Actor;
import models.Award;

public class Runner {


    public static void main(String[] args) {

        Actor actor = new Actor("James", 4555);
        DBHelper.save(actor);

        Award oscar = new Award("Oscar");
        DBHelper.save(oscar);



    }
}


