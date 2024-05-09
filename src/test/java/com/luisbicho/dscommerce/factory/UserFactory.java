package com.luisbicho.dscommerce.factory;

import com.luisbicho.dscommerce.entities.Role;
import com.luisbicho.dscommerce.entities.User;

import java.time.LocalDate;

public class UserFactory {

    public static User createClientUser() {
        User user = new User(1L, "Maria", "maria@gmail.com", "933932901", LocalDate.parse("2001-07-25"), "$2a$10$SrcNQ0X/Q2kIlsP7rMYYWOENfHMj1ACWsiLoUidgIiybCsLGP1Opu");
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }

    public static User createAdminUser() {
        User user = new User(2L, "Alex", "alex@gmail.com", "932323523", LocalDate.parse("1987-12-13"), "$2a$10$SrcNQ0X/Q2kIlsP7rMYYWOENfHMj1ACWsiLoUidgIiybCsLGP1Opu");
        user.addRole(new Role(2L, "ROLE_ADMIN"));
        return user;
    }

    public static User createCustomClientUser(Long id, String username) {
        User user = new User(id, "Maria", username, "932323523", LocalDate.parse("2001-07-25"), "$2a$10$SrcNQ0X/Q2kIlsP7rMYYWOENfHMj1ACWsiLoUidgIiybCsLGP1Opu");
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }

    public static User createCustomAdminUser(Long id, String username) {
        User user = new User(id, "Alex", username, "932323523", LocalDate.parse("1987-12-13"), "$2a$10$SrcNQ0X/Q2kIlsP7rMYYWOENfHMj1ACWsiLoUidgIiybCsLGP1Opu");
        user.addRole(new Role(2L, "ROLE_ADMIN"));
        return user;
    }

}
