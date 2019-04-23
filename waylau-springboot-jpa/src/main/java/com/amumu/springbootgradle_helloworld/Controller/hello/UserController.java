package com.amumu.springbootgradle_helloworld.Controller.hello;

import com.amumu.springbootgradle_helloworld.domain.User;
import com.amumu.springbootgradle_helloworld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 * @Author: amumu
 * @Date: 2019/4/15 0015 下午 18:44
 * @Version 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController{
    @Autowired
    private UserRepository userRepository;

    @GetMapping     //即默认为空
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    @GetMapping("/{id}") //PathVariable为指代路径中的id值
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        Optional<User> user  = userRepository.findById(id);
        model.addAttribute("user", user.orElse(null));  //存在则返回不存在则返回null,会跳转error
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
        userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    //删除
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users"); //重定向
    }

    //修改
    @GetMapping(value = "modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
