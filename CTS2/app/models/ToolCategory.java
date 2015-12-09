package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="toolcategory")
public class ToolCategory extends Model{

    @Id
    public Long cid;


    @Constraints.Required
    public String cname;

    public static Finder<Long,ToolCategory> find = new Finder<Long,ToolCategory>(ToolCategory.class);

}
