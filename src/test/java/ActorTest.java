import models.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ActorTest {

    Actor actor;
    Award award;
    Award award2;
    Film film;
    Director director;
    Studio studio;


    @Before
    public void setUp(){
        actor = new Actor("Feleity Jones",500000,0);
        award = new Award("Oscar");
        award2 = new Award("Razzy");
        director = new Director("Stephen",300);
        studio = new Studio("Paramount", 30000);
        film = new Film("Once", 200, director,Genre.DRAMA,studio,4);
    }

    @Test
    public void canAddAward(){
        actor.addAawrd(award);
        assertEquals(1,actor.awardCount());
    }

    @Test
    public void canRemoveAward(){
        actor.addAawrd(award);
        actor.addAawrd(award2);
        actor.removeAward(award);
        assertEquals(1,actor.awardCount());
    }

    @Test
    public void canRemoveAllAwards(){
        actor.addAawrd(award);
        actor.addAawrd(award2);
        actor.removeAllAwards();
        assertEquals(0,actor.awardCount());
    }

    @Test
    public void returnsStringWithFilm(){
        actor.addFilm(film);
        assertEquals("I'm acting in Once", actor.act());
    }
}
