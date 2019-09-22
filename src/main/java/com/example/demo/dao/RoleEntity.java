package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "bank_um_role")
public class RoleEntity {

    @Id
    @NotNull
    @Column(name = "role_name", nullable = false)
    private String roleName;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bank_um_role_privilege", joinColumns = {@JoinColumn(name = "role_name")}, inverseJoinColumns = {@JoinColumn(name = "privilege_name")})
    private Set<PrivilegeEntity> privileges;

    public Set<PrivilegeEntity> getPrivileges() {

        return privileges;
    }

    public void setPrivileges(Set<PrivilegeEntity> privileges) {

        this.privileges = privileges;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
