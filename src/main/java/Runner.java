import db.*;
import models.*;

import java.util.List;

public class Runner {


    public static void main(String[] args) {

        Actor actor = new Actor("James", 4555,0);
        DBHelper.save(actor);

        Award oscar = new Award("Oscar");
        DBHelper.save(oscar);

        Studio studio = new Studio("Paramount",500000000);
        DBHelper.save(studio);

        Director director = new Director("Gareth Edwards", 50000);
        DBHelper.save(director);

        Film film1 = new Film("Star Wars",1000000, director, Genre.SCIFI,studio,4);
        DBHelper.save(film1);

        Film film2 = new Film("Monsters", 2000000,director, Genre.SCIFI,studio,3);
        DBHelper.save(film2);

        Film film3 = new Film("Hireditory", 30000,director, Genre.HORROR,studio,2);
        DBHelper.save(film3);

        film1.setTitle("Rouge One");
        DBHelper.update(film1);

        DBActor.addActorToAward(actor, oscar);

        DBStudio.addActorToStudio(studio, actor);

        DBFilm.addActors(actor, film1);
        DBFilm.addActors(actor, film2);
        DBFilm.addActors(actor, film3);


        List<Film> directorsFilms = DBDirector.getAllFilms(director);

        List<Film> studiosFilms = DBStudio.getStudiosActors(studio);

        List<Film> actorsFilms = DBActor.getAllActorsFilms(actor);

        List<Film> actorsFilmsGenere = DBActor.getAllActorsFilmsGenre(actor, Genre.SCIFI);

        List<Actor> studiosActors = DBStudio.getStudiosActor(studio);

        List<Actor> filmsActors = DBFilm.getFilmsActors(film1);




    }
}


