package com.mderyol.demo.redis.controller;

import com.mderyol.demo.redis.model.User;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final RedisTemplate<String, Object> redisTemplate;

    @PostMapping
    public void addUser(@RequestBody User user) {
        redisTemplate.opsForValue().set(user.getId(), user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return (User) redisTemplate.opsForValue().get(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return Objects.requireNonNull(redisTemplate.keys("*")).stream()
                .map(key -> (User) redisTemplate.opsForValue().get(key))
                .collect(Collectors.toList());
    }
}
