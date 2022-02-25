package application.repository;

import application.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserRepository {

    private static UserRepository userRepository;

    private UserRepository() {}

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    List<User> users = new ArrayList<>();

    public User add(User user) {
        users.add(user);
        return user;
    }

    public User findByUserId(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public int size() {
        return users.size();
    }
}
