package com.mderyol.demo.redis.service;

import com.mderyol.demo.redis.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<Long, User> userStore = new HashMap<>();

    public User createUser(User user) {
        userStore.put(user.getId(), user);
        return user;
    }

    @Cacheable(value = "users", key = "#id")
    public User getUserById(Long id) {
        return userStore.get(id);
    }

    @CachePut(value = "users", key = "#user.id")
    public User updateUser(User user) {
        userStore.put(user.getId(), user);
        return user;
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(Long id) {
        userStore.remove(id);
    }
}
