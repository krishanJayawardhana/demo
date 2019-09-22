package com.example.demo.dao;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity(name = "bank_um_privilege")
public class PrivilegeEntity {


    @Id
    private String privilegeName;

    @JsonBackReference
    @ManyToMany(mappedBy = "privileges", fetch = FetchType.LAZY)
    Collection<RoleEntity> roles;

    public Collection<RoleEntity> getRoles() {

        return roles;
    }

    public void setRoles(Collection<RoleEntity> roles) {

        this.roles = roles;
    }

    public String getPrivilegeName() {

        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }
}
