package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;

@Controller
@SessionAttributes("user")
public class UserController {

    @GetMapping("/user")
    public ModelAndView getUserPage(@ModelAttribute User user) {
        ModelAndView model = new ModelAndView("user");
        model.addObject(user);
        return model;
    }
}
