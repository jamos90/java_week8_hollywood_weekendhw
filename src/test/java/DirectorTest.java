import models.Director;
import models.Film;
import models.Genre;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DirectorTest {

    Director director;
    Film film;
    Studio studio;

    @Before
    public void setUp(){

        director = new Director("Gareth Edwards",500000);
        studio = new Studio("Paramount", 5000000);
        film = new Film("Rouge One", 403000, director, Genre.SCIFI,studio,2);
    }

    @Test
    public void canAddFilms(){
        director.addFilm(film);
        assertEquals(1,director.filmCount());
    }
}
