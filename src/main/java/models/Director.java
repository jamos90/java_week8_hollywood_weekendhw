package models;

import java.util.ArrayList;
import java.util.List;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
