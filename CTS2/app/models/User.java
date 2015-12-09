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

    public String password_hash;


    public String firstname;

    public String lastname;

    public String address;

    public String email;

    public String phone;


    // Finder object for easier quering
    public static Finder<String, User> find = new Finder(String.class, User.class);

    // NOT FOR PRODUCTION - must ensure this is a valid user first. I have not done that.

    public boolean authenticate(User user, String password)
    {
        if(user!=null){
        return BCrypt.checkpw(password, user.password_hash);
    }
    else {
            return false;
        }
    }


    public static User createUser(String username, String password){


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


             return user;
        }
     }

