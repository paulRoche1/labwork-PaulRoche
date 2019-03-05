package models.users;

import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class User extends Model
{
    @id
    private String email;

    @Constraints.Required
    private String role;

    @Constraints.Required
    private String name;

    @Constraints.Required
    private String password;

    public Users(){
    }

    public Users(String email, String role, String name, String password){
        this.email = email;
        this.role = role;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setId(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public static final Finder<Long, User> find = new Finder<>(ItemOnSale.class);
			    
    public static User authenticate(String email, String password) 
    {
        return find.query().where().eq("email", email).eq("password", password).findUnique();
    }
       





}