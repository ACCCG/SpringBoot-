package com.amumu.springbootgradle_helloworld.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 *
 * @Author: amumu
 * @Date: 2019/4/24 0024 下午 4:37
 * @Version 1.0
 */
@EnableWebSecurity      //启用web安全
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //重写了一个拦截类，用来相关设置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()   //都可以访问
                .antMatchers("/users/**").hasRole("ADMIN")                             //  需要管理员权限

                .and()
                .formLogin()      //基于form表单验证
                .loginPage("/login").failureUrl("/login-error");        //自定义登陆界面*/

        //新的,抄的简书
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/users/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/hello")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }

    //添加一个极简的认证信息管理
    @Autowired          //注入
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("amumu")
                .password("111")
                .roles("ADMIN");*/
    }
}
