package models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "directors")

public class Director {


    private  int id;
    private String name;
    private double salary;
    private List<Film> films;
    private List<Studio> studios;

    public Director(){}

    public Director(String name, double salary){
        this.name = name;
        this.salary = salary;
        this.films = new ArrayList<Film>();
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


    @Column(name= "names")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


   @Column(name = "salaries")
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film){
        this.films.add(film);
    }

    public int filmCount() {
        return this.films.size();
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "studios_directors",
    joinColumns = {@JoinColumn(name="director_id",nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name = "studio_id", nullable = false, updatable = false)})
    public List<Studio> getStudios() {
        return studios;
    }

    public void setStudios(List<Studio> studios) {
        this.studios = studios;
    }
}
