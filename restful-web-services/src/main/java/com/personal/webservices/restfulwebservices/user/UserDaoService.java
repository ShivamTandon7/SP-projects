package com.personal.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();
    private static int usersCount = 0;
    static {
        userList.add(new User(++usersCount,"Adam",LocalDate.now().minusYears(30)));
        userList.add(new User(++usersCount,"Eve",LocalDate.now().minusYears(20)));
        userList.add(new User(++usersCount,"Jim",LocalDate.now().minusYears(10)));
    }

    public List<User> findAll() {
        return userList;
    }

    public User save (User user){
        user.setId(++usersCount);
        userList.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return userList.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        userList.removeIf(predicate);
    }
}
