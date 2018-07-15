package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studios")

public class Studio {

    private  int id;
    private String name;
    private double budget;
    private List<Director> directors;
    private List<Actor> actors;
    private List<Film> films;

   public Studio(){}

   public Studio(String name, double budget){
       this.name = name;
       this.budget = budget;
       this.directors = new ArrayList<Director>();
       this.actors = new ArrayList<Actor>();
       this.films = new ArrayList<Film>();
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

    @Column(name = "id")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "budget")
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @ManyToMany
    @JoinTable(name = "studios_directors",
    joinColumns = {@JoinColumn(name="studio_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="director_id", nullable = false, updatable = false)})
    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }


    @ManyToMany
    @JoinTable(name= "studios_actors",
    joinColumns = {@JoinColumn(name ="studio_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)})
    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @OneToMany(mappedBy= "studio", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
