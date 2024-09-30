package prog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import prog.dao.UserDAO;
import prog.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userDAO.findAll());
        return "user-list";
    }

    @GetMapping("/new")
    public String showFormForAdd(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("email") String email) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        userDAO.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String showFormForUpdate(@RequestParam("userId") Long id, Model model) {
        User user = userDAO.findById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("email") String email) {
        User user = userDAO.findById(id);
        user.setName(name);
        user.setEmail(email);
        userDAO.update(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") Long id) {
        userDAO.delete(id);
        return "redirect:/users";
    }
}
