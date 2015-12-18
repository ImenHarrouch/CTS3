package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Constraint;


@Entity
@Table(name="tools")
public class Tool extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String description;

    @Constraints.Required
    public String owner;

    @Constraints.Required
    public String category;

    @OneToMany
    public String comment;



    public static Finder<Long, Tool> find = new Finder<Long,Tool>(Tool.class);}
