package com.hashmi.bankingapp;

import jakarta.persistence.*;

// @Entity tell JPA to map the class into a table named User
@Entity
// Name the table as users to avoid the reserved word `user`
@Table(name = "users")
public class User {
    // @Id marks this field as the primary key for unique users
    @Id
    // id field is auto generated using SEQUENCE in Postgresql
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    String email;
    String password;

    @OneToMany (mappedBy = "User", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Account account;

    // No arg constructor for JPA
    public User() {}

    // Constructor to create User objects manually for testing
    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // toString method for testing
    @Override
    public String toString() {
        return "User [" +
                " ID=" + id +
                ", firstName='" + firstName +
                ", lastName='" + lastName + '\'' +
                ", email='" + email +
                ", password='" + password +
                ']';
    }

    // Getters for all fields
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
