package com.example.demo.dao;

import com.example.demo.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "bank_um_user")
public class UserEntity {

    @Id
    @Column(name = "user_name")
    @NotNull
    //@Size(min = 8, max = 15)
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bank_um_user_role", joinColumns = {@JoinColumn(name = "user_name")}, inverseJoinColumns = {@JoinColumn(name = "role_name")})
    private Set<RoleEntity> roles;

    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Set<RoleEntity> getRoles() {

        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
