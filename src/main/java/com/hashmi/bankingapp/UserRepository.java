package com.hashmi.bankingapp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// CRUD Repo for Users
public interface UserRepository extends CrudRepository<User, Long> {

    // Methods for support team to help find users with different variables
    List<User> findByEmail(String email);
    List<User> findByLastName(String lastName);

}
