import db.DBActor;
import db.DBHelper;
import models.*;

public class Runner {


    public static void main(String[] args) {

        Actor actor = new Actor("James", 4555);
        DBHelper.save(actor);

        Award oscar = new Award("Oscar");
        DBHelper.save(oscar);


        Director director = new Director("Gareth Edwards", 50000);
        DBHelper.save(director);

        Film film1 = new Film("Star Wars",1000000, director, Genre.SCIFI);
        DBHelper.save(film1);


        DBActor.addActorToAward(actor, oscar);




    }
}


