package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
@Table(name="todo")
public class ToDo extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    public String description;
    public boolean done;

    public ToDo(String description, boolean done) {
        this.description = description;
        this.done = done;
    }
    
    public static Finder<Long, ToDo> find = new Finder<Long,ToDo>(ToDo.class);


}