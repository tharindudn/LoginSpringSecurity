package secure.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tharindu on 7/27/17.
 */
@Entity
@Table(name="user_roles")
public class User {
    @Id
    @Column(name="username")
    private String name;
    @Column(name="role")
    private  String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}