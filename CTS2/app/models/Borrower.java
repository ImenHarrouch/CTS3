package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="borrowerdetails")
public class Borrower extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String firstname;

    @Constraints.Required
    public String lastname;


    @Constraints.Required
    public String address;

    @Constraints.Required
    public String city;

    /*@Constraints.Required
    public String state;*/

    @Constraints.Required
    public String zip;

    @Constraints.Required
    public String email;

    @Constraints.Required
    public String phone;

    public static Finder<Long, Borrower> find = new Finder<Long,Borrower>(Borrower.class);}