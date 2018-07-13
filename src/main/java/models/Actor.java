package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "actors")

public class Actor {
    private  int id;
    private String name;
    private double fee;
    private List<Film> films;
    private List<Award> awards;



}
