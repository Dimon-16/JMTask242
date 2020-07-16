package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.DAO.UserDAO;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String indexMethod(ModelMap model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("list", list);
        return "admin";
    }
}
