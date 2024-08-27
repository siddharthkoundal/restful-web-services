package com.restDemo.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    // JPA/Hibernate -> DB
    // UserDaoService -> Static List

    private static final List<User> users = new ArrayList<>();
    private static int users_count = 0;

    static {
        users.add(new User(++users_count, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++users_count, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++users_count, "Pam", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++users_count);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
