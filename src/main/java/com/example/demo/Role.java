package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Collection;
import java.util.List;

public class Role {

    private String name;

    private Collection<Privilege> privileges;

    public Collection<Privilege> getPrivileges() {

        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {

        this.privileges = privileges;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
