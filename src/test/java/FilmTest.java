import models.Director;
import models.Film;
import models.Genre;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FilmTest {

    Film film;
    Director director;

    @Before
    public void setUp(){
        director = new Director("Gareth Edwards", 500000);
        film = new Film("Star Wars",2000000, director, Genre.SCIFI);
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

}
