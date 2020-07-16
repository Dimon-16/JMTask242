package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.Map;

@Controller
public class UpdateController {
    @Autowired
    private UserService userService;

    @Autowired
    private IndexController indexController;

    @PostMapping("/admin/update")
    public String updateTable(@RequestParam Map<String, String> param, ModelMap model) {
        long id =Long.parseLong(param.get("id"));
        String name = param.get("name");
        String lastName = param.get("lastName");
        int age = Integer.parseInt(param.get("age"));
        userService.updateUser(id, new User(name, lastName, age));
        return indexController.indexMethod(model);
    }
}
