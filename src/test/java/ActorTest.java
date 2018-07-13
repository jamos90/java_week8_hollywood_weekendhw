import models.Actor;
import models.Award;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ActorTest {

    Actor actor;
    Award award;
    Award award2;


    @Before
    public void setUp(){
        actor = new Actor("Feleity Jones",500000);
        award = new Award("Oscar");
        award = new Award("Razzy");
    }

    @Test
    public void canAddAward(){
        actor.addAawrd(award);
        assertEquals(1,actor.getAwardCount());
    }

    @Test
    public void canRemoveAward(){
        actor.addAawrd(award);
        actor.addAawrd(award2);
        actor.removeAward(award);
        assertEquals(1,actor.getAwardCount());
    }

    @Test
    public void canRemoveAllAwards(){
        actor.addAawrd(award);
        actor.addAawrd(award2);
        actor.removeAllAwards();
        assertEquals(0,actor.getAwardCount());
    }
}
