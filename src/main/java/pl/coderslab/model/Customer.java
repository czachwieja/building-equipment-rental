package pl.coderslab.model;

import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email
    @Pattern(regexp = "[^@]+@[^\\.]+\\..+")
    private String login;

    @NotEmpty
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NIP
    private String nip;

    private String companyName;

    private String Address;

}
