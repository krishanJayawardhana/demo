package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RestController("/user")
public class UserController {

    @GetMapping
    public ResponseEntity<User> getUser() {

        User user = new User();
        user.setName("Kamal");

        ResponseEntity entity = ResponseEntity.ok().header("PPPP", "FFFFFFF").body(build());
        //entity.getHeaders().add("PPPP", "FFFFFFF");

        return entity;
    }

    private User build() {

        User user = new User();
        user.setName("Kamal");

        Set<Role> roleSet = new HashSet<>();
        Role role1 = new Role();
        role1.setName("Role1");
        roleSet.add(role1);
        Role role2 = new Role();
        role1.setName("Role2");
        roleSet.add(role2);
        Role role3 = new Role();
        role1.setName("Role3");
        roleSet.add(role3);
        Role role4 = new Role();
        role1.setName("Role4");
        roleSet.add(role4);


        Collection<Privilege> privileges = new ArrayList<>();
        Privilege privilege1 = new Privilege();
        privilege1.setName("Privilege1");
        privileges.add(privilege1);
        Privilege privilege2 = new Privilege();
        privilege1.setName("Privilege2");
        privileges.add(privilege2);

        roleSet.stream().forEach(role -> {

            role.setPrivileges(privileges);
        });

        privileges.forEach(privilege -> {

            privilege.setRoles(roleSet);
        });

        user.setRoles(roleSet);
        return user;
    }
}
