package club.mymmm.springbootmybatisstudy.controller.admin;

import club.mymmm.springbootmybatisstudy.entity.User;
import club.mymmm.springbootmybatisstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/displayAllData")
    public List<User> displayAllData() {
        return userService.findAll();
    }

    @RequestMapping("/findByIds")
    public List<User> findByIds(HttpServletRequest request) {
        return userService.findById(Integer.valueOf(request.getParameter("id")));
    }

    @RequestMapping("/addUser")
    public void addUser(HttpServletRequest request) {
        userService.create(new User(request.getParameter("email"),
                request.getParameter("name"),
                request.getParameter("password")));
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request) {
        userService.delete(Integer.valueOf(request.getParameter("id")));
    }

    @RequestMapping("/update")
    public void update(HttpServletRequest request) {
        userService.update(new User(request.getParameter("email"),
                request.getParameter("name"),
                request.getParameter("password")));
    }

}
