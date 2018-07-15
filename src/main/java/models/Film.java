package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")

public class Film {

    private  int id;
    private String title;
    private double cost;
    private Director director;
    private List<Actor> actors;
    private Genre genre;
    private Studio studio;


    public Film(){}

    public Film(String title, double cost, Director director,Genre genre, Studio studio) {
        this.title = title;
        this.cost = cost;
        this.director = director;
        this.actors = new ArrayList<Actor>();
        this.genre = genre;
        this.studio = studio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "titles")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Column(name = "costs")
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    @ManyToOne
    @JoinColumn(name = "directors_id")
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "actors_films",
    joinColumns = {@JoinColumn(name="film_id",nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)})

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }


    @Column(name = "genres")
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int actorsCount() {
       return this.actors.size();
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    @ManyToOne
    @JoinColumn(name="studios_id")
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}


