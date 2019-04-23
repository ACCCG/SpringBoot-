package com.amumu.springbootgradle_helloworld.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: amumu
 * @Date: 2019/4/15 0015 下午 18:01
 * @Version 1.0
 */

@Entity //实体
public class User {

    @Id //这是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //这是数据库自增策略
    private Long id;//唯一标识
    private String name;
    private String email;

    //构造函数
    public User() { //防止protect 直接使用
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
