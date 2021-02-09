package vita.all.web.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Table(name = "role")
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role")
    private String role;

    //    @Transient
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY) // тоже узнай, что внутри скобок
    private Set<User> users;

    public Role(int id){
        this.id = id;
    }

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role() { }

    public Set<User> getUsers(){
        return users;
    }

    public void setUsers(Set<User> user){
        this.users = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }
}
