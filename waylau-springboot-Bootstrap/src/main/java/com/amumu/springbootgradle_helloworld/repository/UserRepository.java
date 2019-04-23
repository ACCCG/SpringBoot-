package com.amumu.springbootgradle_helloworld.repository;

import com.amumu.springbootgradle_helloworld.domain.User;

import java.util.List;

/**
 * @Author: amumu
 * @Date: 2019/4/15 0015 下午 18:05
 * @Version 1.0
 */
public interface UserRepository {
    /**
     * 创建或者修改用户的 repository 接口
     *
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 根据ids查询用户
     *
     * @return
     */
    List<User> listUsers();
}
