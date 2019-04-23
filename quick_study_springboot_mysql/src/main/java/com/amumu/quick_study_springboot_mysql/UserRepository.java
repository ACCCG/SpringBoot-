package com.amumu.quick_study_springboot_mysql;

import com.amumu.quick_study_springboot_mysql.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
*   Crud
*   create read update delete
* */
public interface UserRepository extends CrudRepository<User, Integer> {

    //Spring会自动帮你将findByEmail转换成SQL语言中的`SELECT * FROM UserRepository WHERE email = 'email'
    List<User> findByEmail(String email);

    void deleteByEmail(String email);
}
