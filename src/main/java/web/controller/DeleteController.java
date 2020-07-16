package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;

import java.util.Map;

@Controller
public class DeleteController {
    @Autowired
    private UserService userService;

    @Autowired
    private IndexController indexController;

    @PostMapping("/admin/delete")
    public String updateTable(@RequestParam Map<String, String> param, ModelMap model) {
        long id =Long.parseLong(param.get("id"));
        userService.deleteUser(id);
        return indexController.indexMethod(model);
    }
}
