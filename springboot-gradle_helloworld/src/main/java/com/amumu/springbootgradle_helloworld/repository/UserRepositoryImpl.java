package com.amumu.springbootgradle_helloworld.repository;

import com.amumu.springbootgradle_helloworld.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: amumu
 * @Date: 2019/4/15 0015 下午 18:12
 * @Version 1.0
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    //这个是自动的计数器
    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();

    public UserRepositoryImpl(){
        User user = new User();
        //user.setAge(18);
        user.setEmail("safasf@fafa.com");
        user.setName("amumufdfasx");
        this.saveOrUpdateUser(user);
    }

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        //ConcurrentMap的put方法，若是key存在的情况下，会替换掉value
        //putIfAbsent则是不替换掉value
        this.userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<User>(userMap.values());
    }
}