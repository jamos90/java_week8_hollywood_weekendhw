import models.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class StudioTest {

    Studio studio;
    Studio studio2;
    Actor actor;
    Actor actor2;
    Director director;
    Film film;

    @Before
    public void setUp(){
        studio = new Studio("Paramount", 2000000);
        studio2 = new Studio("Tri Star", 1000);
        actor = new Actor("James", 2003,0);
        actor2 = new Actor("James", 2003,0);
        director = new Director("Gareth Edwards", 5000);
        film = new Film("Rouge One", 2000,director, Genre.SCIFI, studio,4);

    }

    @Test
    public void canAddActor(){
        studio.addActor(actor);
        assertEquals(1,studio.actorsCount());
    }

    @Test
    public void canRemoveActor(){
        studio.addActor(actor);
        studio.addActor(actor2);
        studio.removeActor(actor);
        assertEquals(1,studio.actorsCount());
    }

    @Test
    public void actorExists(){
        studio.addActor(actor);
        assertEquals(true,studio.actorExists(actor));
    }

    @Test
    public void cannotAddActorIfAlreadyAdded() {
        studio.addActor(actor);
        studio.addActor(actor);
        assertEquals(1,studio.actorsCount());
    }

    @Test
    public void canAffordToMakeMovieActor(){
        studio.addActor(actor);
        studio.removeActorsFee(actor);
        assertEquals(1997997,studio.getBudget(),0.1);
    }

    @Test
    public void cannotAffordMovieActor(){
        studio2.addActor(actor);
        studio2.removeActorsFee(actor);
        assertEquals(1000,studio2.getBudget(),0.1);
    }

    @Test
    public void canPayActor(){
        studio.payActor(actor);
        assertEquals(2003,actor.getMoney(),0.1);
    }

    @Test
    public void makeMovieWorks(){
        studio.addActor(actor);
        studio.addDirector(director);
        studio.addFilm(film);
        studio.makeFilm(film,actor,director);
        assertEquals(1990997,studio.getBudget(),0.1);
    }
}

