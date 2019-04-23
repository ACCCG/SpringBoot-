package club.mymmm.springbootmybatisstudy.service;

import club.mymmm.springbootmybatisstudy.entity.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    List<User> findByName(String name);
}
