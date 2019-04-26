package com.amumu.springbootgradle_helloworld.Controller.hello;

import com.amumu.springbootgradle_helloworld.domain.User;
import com.amumu.springbootgradle_helloworld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: amumu
 * @Date: 2019/4/15 0015 下午 18:44
 * @Version 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private List<User> getUserlist() {
        return userRepository.listUsers();
    }

    @GetMapping     //即默认为空
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.listUsers());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    @GetMapping("/{id}") //PathVariable为指代路径中的id值
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepository.getUserById(id));
        model.addAttribute("title", "用户查询");
        return new ModelAndView("users/view", "userModel", model);
    }

    @GetMapping("/form") //PathVariable为指代路径中的id值
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    @PostMapping
    public ModelAndView create(User user) {
        userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }

    //删除
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userRepository.deleteUser(id);
        return new ModelAndView("redirect:/users"); //重定向
    }

    //修改
    @GetMapping(value = "modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
