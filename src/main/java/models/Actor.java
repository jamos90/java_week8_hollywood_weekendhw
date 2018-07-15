package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")

public class Actor {
    private  int id;
    private String name;
    private double fee;
    private double money;
    private List<Film> films;
    private List<Award> awards;
    private List<Studio> studios;



    public Actor(){}

    public Actor(String name, double fee, double money){
        this.name = name;
        this.fee = fee;
        this.money = money;
        this.films = new ArrayList<Film>();
        this.awards = new ArrayList<Award>();
        this.studios = new ArrayList<Studio>();
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

    @Column(name = "names")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "feess")
    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @ManyToMany
    @JoinTable(name ="actors_films",
    joinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)})
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film){
        this.films.add(film);
    }


    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name ="actors_awards",
            joinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "award_id", nullable = false, updatable = false)})
    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "studios_actors",
    joinColumns = {@JoinColumn(name="actor_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name="studio_id", nullable = false, updatable = false)})
    public List<Studio> getStudios() {
        return studios;
    }

    @Column(name = "money")
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setStudios(List<Studio> studios) {
        this.studios = studios;
    }

    public void addAawrd(Award award){
        this.awards.add(award);
    }

    public void removeAward(Award award){
        this.awards.remove(award);
    }

    public void removeAllAwards(){
        this.awards.clear();
    }

    public int AwardCount() {
        return this.awards.size();
    }

    public void addStudio(Studio studio){
        this.studios.add(studio);
    }

    public void addToMoney(double amount){
        this.money += amount;
    }



}
