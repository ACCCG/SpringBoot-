package com.amumu.springbootgradle_helloworld.repository;

import com.amumu.springbootgradle_helloworld.domain.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @Author: amumu
 * @Date: 2019/4/15 0015 下午 18:05
 * @Version 1.0
 */
//必须继承CurdRepository,其他的都可以不需要了
public interface UserRepository extends CrudRepository<User, Long> {
}
