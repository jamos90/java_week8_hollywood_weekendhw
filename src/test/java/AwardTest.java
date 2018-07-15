import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class AwardTest {

    Award award;
    Actor actor;
    Film film1;
    Film film2;
    Film film3;
    Director director;
    Studio studio;

    @Before
    public void setUp(){
        award = new Award("Oscar");
        director = new Director("Frank",200000);
        studio = new Studio("Paramount", 20000);
        actor = new Actor("James",2000,0);
        film1 = new Film("Rouge One",50000,director,Genre.SCIFI,studio,4 );
        film2 = new Film("Rouge One",50000,director,Genre.SCIFI,studio,3 );
        film3 = new Film("Rouge One",50000,director,Genre.SCIFI,studio,2 );
    }

    @Test
    public void giveAward__oscar(){
        award.giveAwards(film1,actor);
        List<Award> awardGiven = actor.getAwards();
        assertEquals(  "Oscar",awardGiven.get(0).getName());
    }

    @Test
    public void giveAward__null(){
        award.giveAwards(film2,actor);
        assertEquals(0,actor.awardCount());
    }

    @Test
    public void giveAward_razzy(){
        award.giveAwards(film3,actor);
        List<Award> awardGiven = actor.getAwards();
        assertEquals("Razzy",awardGiven.get(0).getName());
    }

}
