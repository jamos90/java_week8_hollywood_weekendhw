import models.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;

public class FilmTest {

    Film film;
    Director director;
    Actor actor;
    Studio studio;

    @Before
    public void setUp(){
        director = new Director("Gareth Edwards", 500000);
        actor = new Actor("Felicity Jones", 400000,0);
        studio = new Studio("Paramount",2000000);
        film = new Film("Star Wars",2000000, director, Genre.SCIFI,studio,3);
    }

    @Test
    public void hasTitle(){
        assertEquals("Star Wars", film.getTitle());
    }


    @Test
    public void hasBuget(){
        assertEquals(2000000, film.getCost(),0.1);
    }


    @Test
    public void hasDirector(){
        assertEquals(director, film.getDirector());
    }

    @Test
    public void hasActorsList(){
        assertEquals(0, film.actorsCount());
    }

    @Test
    public void canAddActorsToFilm(){
        film.addActor(actor);
        assertEquals(1,film.actorsCount());
    }


}
