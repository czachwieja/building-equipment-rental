package pl.coderslab.model;

import org.hibernate.validator.constraints.pl.NIP;
import org.springframework.security.core.GrantedAuthority;

import javax.lang.model.element.Name;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Set;

@Entity
//@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    //    @Email
//    @Pattern(regexp = "[^@]+@[^\\.]+\\..+")
//    private String username;

//    @NotEmpty
//    private String password;

//    private int enabled;

//    @NotEmpty
//    private String firstName;

//    @NotEmpty
//    private String lastName;

//    @NIP
//    private String nip;

//    private String companyName;

//    private String Address;


    public User() {
    }

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
    }


}
