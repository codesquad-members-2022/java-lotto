package application.repository;

import application.domain.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {

    private static final String USER_NOT_FOUND = "해당 유저의 정보가 존재하지 않습니다.";

    private static UserRepository userRepository;

    private UserRepository() {}

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    Map<Integer, User> userMap = new HashMap<>();

    private AtomicInteger userId = new AtomicInteger(0);

    public User create(int money) {
        int id = userId.incrementAndGet();
        User user = new User(id, money);
        userMap.put(id, user);
        return user;
    }

    public User findByUserId(int userId) {
        return Optional.ofNullable(userMap.get(userId))
                .orElseThrow(() -> new NoSuchElementException(USER_NOT_FOUND));
    }

    public void deleteById(int userId) {
        Optional.ofNullable(userMap.remove(userId))
                .orElseThrow(() -> new NoSuchElementException(USER_NOT_FOUND));
    }
}
