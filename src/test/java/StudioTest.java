import models.Actor;
import models.Director;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class StudioTest {

    Studio studio;
    Actor actor;
    Actor actor2;
    Director director;

    @Before
    public void setUp(){
        studio = new Studio("Paramount", 2000000);
        actor = new Actor("James", 2003);
        actor2 = new Actor("James", 2003);
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
}

