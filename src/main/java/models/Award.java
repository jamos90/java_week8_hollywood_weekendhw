package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
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
        this.actors = new ArrayList<Actor>();
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

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
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

    public int actorsListSize(){
        return this.actors.size();
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }

    public void remooveActorsFromAwards(Actor actor){
        this.actors.remove(actor);
    }

    public void reamoveAllActorsFromAwards(Actor actor){
        this.actors.clear();
    }
}
