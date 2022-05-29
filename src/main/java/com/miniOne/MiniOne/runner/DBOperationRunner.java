package com.miniOne.MiniOne.runner;

import java.util.Arrays;

import com.miniOne.MiniOne.entity.Role;
import com.miniOne.MiniOne.entity.User;
import com.miniOne.MiniOne.repository.RoleRepo;
import com.miniOne.MiniOne.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DBOperationRunner implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    @Override
    public void run(String... args) throws Exception {

        Role adminRole = new Role();
        adminRole.setRole("ADMIN");

        Role normalRole = new Role();
        normalRole.setRole("NORMAL");

        roleRepo.saveAll(Arrays.asList(adminRole,normalRole));

        User admin = new User();
        admin.setEmail("admin@admin.com");
        admin.setPassword("1");
        admin.setRoles(Arrays.asList(adminRole));
        User normal = new User();
        normal.setEmail("normal@normal.com");
        normal.setPassword("1");
        normal.setRoles(Arrays.asList(normalRole));

        userRepo.saveAll(Arrays.asList(
                admin,normal
        ));

        System.out.println("----------All User Data saved into Database----------------------");
        System.out.println("----------email for admin:admin@admin.com pass:1----------------------");
        System.out.println("----------email for normal user:normal@normal.com pass:1----------------------");
    }
}
