package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "directors")

public class Director {


    private  int id;
    private String name;
    private double salary;
    private List<Film> films;

    public Director(){}

    public Director(String name, double salary){
        this.name = name;
        this.salary = salary;
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
}
