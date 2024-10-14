package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.services.UserService;

@Controller
public class MainController {
    private UserService userServices;

    @Autowired
    public MainController(UserService userServices) {
        this.userServices = userServices;
    }

    public MainController() {
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("users", userServices.findAll());
        return "index";
    }

    @GetMapping("/edit")
    public String editUser(ModelMap model, @RequestParam Long id) {
        model.addAttribute("edit", userServices.get(id));
        return "editUser";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userServices.delete(id);
        return "redirect:/";
    }

    @GetMapping("/newUser")
    public String addUser(ModelMap model) {
        model.addAttribute("newUser", new User());
        return "newUser";
    }

    @PostMapping("save")
    public String save(@ModelAttribute User user) {
        userServices.save(user);
        return "redirect:/";
    }
}