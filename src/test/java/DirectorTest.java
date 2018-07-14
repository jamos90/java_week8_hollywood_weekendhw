import models.Director;
import models.Film;
import models.Genre;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DirectorTest {

    Director director;
    Film film;

    @Before
    public void setUp(){

        director = new Director("Gareth Edwards",500000);
        film = new Film("Rouge One", 403000, director, Genre.SCIFI);
    }

    @Test
    public void canAddFilms(){
        director.addFilm(film);
        assertEquals(1,director.filmCount());
    }
}
