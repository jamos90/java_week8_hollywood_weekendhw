package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "awards")

public class Award {
    private int id;
    private String name;
    private List<Actor> actors;

    public Award(){}

    public Award(String name){
        this.name = name;
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

    @Column(name = "awards")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name ="actors_awards",
            joinColumns = {@JoinColumn(name = "award_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)})
    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
