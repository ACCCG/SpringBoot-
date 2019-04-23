package com.amumu.quick_study_springboot_mysql;

import com.amumu.quick_study_springboot_mysql.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    //创建新的用户
    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name,
                      @RequestParam String email,
                      @RequestParam String password,
                      User user) {
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        userRepository.save(user);
        log.info(user.toString() + " saved to the repo");
        return "saved";
    }

    /**
     * 登陆方法, 用户输入邮箱和密码, 查询数据库检验是否有该账户,如果有,
     * 返回原先页面 ,登陆成功。
     *
     * @param email    用户邮箱
     * @param password 用户密码
     * @param model    Spring MVC中的Model，用来储存经过controller处理后的信息，再由View层渲染
     *                 得到前端页面。
     * @return index
     */
    @RequestMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        List<User> users = userRepository.findByEmail(email);
        if (users == null || users.size() == 0) {
            log.warn("attempting to log in with the non-existed account");
            return "此用户不存在";
        } else {
            User user = users.get(0);
            if (user.getPassword().equals(password)) {
                model.addAttribute("name", user.getName());
                log.warn(user.toString() + " loggin in");
            } else {
                model.addAttribute("name" + "loggin failed");
                log.warn(user.toString() + "failed to log in");
            }
            return "index";
        }
    }

    /**
     * 域名的根目录，然后返回的“index”会映射到
     * java/resources/templates/index.html文件。
     *
     * @param name
     * @return
     */
    @GetMapping(path="/")
    public String welcomePage(@RequestParam(name = "name", required = false, defaultValue = "world") String name1) {
        return "index";
    }

    /**
     * 查看所有用户的注册信息，按照Spring Boot的设定，以Json的形式输送给用户端。
     * @return
     */
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
