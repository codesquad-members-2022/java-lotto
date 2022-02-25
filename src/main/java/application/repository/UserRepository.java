package application.repository;

import application.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

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
                .orElseThrow(() -> new NoSuchElementException("해당 유저가 존재하지 않습니다."));
    }

    public int size() {
        return users.size();
    }
}
