package ru.itsnotfedya.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itsnotfedya.spring.model.User;
import ru.itsnotfedya.spring.service.UsersService;


@Controller
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping(value = "/")
    public String showUsers(Model model) {
        model.addAttribute("usersToShow", usersService.getUsers());
        return "users";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("newUser") User user) {
        usersService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String editUser(@RequestParam Long id, Model model) {
        model.addAttribute("userToEdit", usersService.getUserById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String updateUser(@ModelAttribute("userToEdit") User user) {
        usersService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam Long id) {
        usersService.deleteUser(id);
        return "redirect:/";
    }
}
