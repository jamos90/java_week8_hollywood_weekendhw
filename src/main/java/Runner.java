import db.DBActor;
import db.DBDirector;
import db.DBHelper;
import models.*;

import java.util.List;

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

        Film film2 = new Film("Monsters", 2000000,director, Genre.SCIFI);
        DBHelper.save(film2);


        DBActor.addActorToAward(actor, oscar);

        List<Film> directorsFilms = DBDirector.getAllFilms(director);




    }
}


