package models;


import com.avaje.ebean.Model;
import org.mindrot.jbcrypt.BCrypt;
import play.data.validation.Constraints;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.Constraint;

@Table(name="users")
@Entity
public class User extends Model {

    @Id
    public Long id;


    @Constraints.Required
    @Column(unique=true)
    public String username;

    @Constraints.Required
    public String password_hash;


    @Constraints.Required
    public String firstname;


    @Constraints.Required
    public String lastname;


    @Constraints.Required
    public String address;

    @Constraints.Required
    public String email;

    @Constraints.Required
    public String phone;


    // Finder object for easier quering
    public static Finder<String, User> find = new Finder(String.class, User.class);

    // NOT FOR PRODUCTION - must ensure this is a valid user first. I have not done that.

    public boolean authenticate(String password)
    {
        //if(u != null){
        return BCrypt.checkpw(password, this.password_hash);
    /*}
    else {
            return false;
        }*/
    }


    public static User createUser(String username, String password, String firstname, String lastname, String email, String phone, String address)
    {

             // requirements for username and password
             if(password==null || username==null && password.length()<8)
             {
                     return null;
             }


             // create a password hash
             String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
             // create a new user instance in the database
             // assign the username and passwordHash to the newly created user
             User user = new User();

             user.username = username;
             user.password_hash = passwordHash;
           user.firstname = firstname;
        user.lastname = lastname;
        user.email = email;
        user.phone = phone;
        user.address = address;


             return user;
        }
     }

