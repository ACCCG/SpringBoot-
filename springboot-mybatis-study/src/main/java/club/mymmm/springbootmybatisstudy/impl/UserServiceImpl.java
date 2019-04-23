package club.mymmm.springbootmybatisstudy.impl;

import club.mymmm.springbootmybatisstudy.entity.User;
import club.mymmm.springbootmybatisstudy.mapper.UserMapper;
import club.mymmm.springbootmybatisstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public void create(User user) {
        userMapper.create(user);
    }

    @Override
    public void delete(int ids) {
        userMapper.delete(ids);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }
}
