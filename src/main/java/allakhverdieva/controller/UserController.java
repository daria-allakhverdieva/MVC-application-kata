package allakhverdieva.controller;

import allakhverdieva.model.User;
import allakhverdieva.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users-page")
    public String getMainPage(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "users/main-page";
    }

    @PostMapping("/add-user")
    public String addUser(@RequestParam String name,
                          @RequestParam String surname,
                          Model model) {
        User user = new User(name, surname);
        userService.saveUser(user);
        model.addAttribute("user", user);
        return "redirect:/users-page";
    }

    @GetMapping("/user")
    public String getUser(@RequestParam(required = false) int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/person-page";
    }

    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute User user, Model model) {
        userService.updateUser(user);
        return "redirect:/users-page";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/users-page";
    }

}
