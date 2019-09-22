package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Set;

public class Privilege {

    private String name;

    @JsonBackReference
    Set<Role> roles;

    public Set<Role> getRoles() {

        return roles;
    }

    public void setRoles(Set<Role> roles) {

        this.roles = roles;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
