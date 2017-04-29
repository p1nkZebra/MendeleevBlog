package controller;

import controller.service.UserService;
import dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public ModelAndView index() {
        String message = "Message from public class UserController";
        return new ModelAndView("index", "message", message);
    }

    // show user list
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String showAllUsers(ModelMap model) {

        List<User> allUsers = userService.findAll();
        model.addAttribute("users", allUsers);

        for (User u : allUsers) {
            System.out.println("user = " + u);
        }
        return "users/list";

    }

    // show user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") long id, ModelMap model) {

        User user = userService.findById(id);
        model.addAttribute("user", user);

        return "users/show";

    }

    // show update form
    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") long id, ModelMap model) {

        User user = userService.findById(id);
        model.addAttribute("userInfo", user);

        return "users/userForm";

    }

    // save or update user
    // 1. @ModelAttribute bind form value
    // 3. RedirectAttributes for flash value
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("userForm") User user, ModelMap model) {


            userService.update(user);

            // POST/REDIRECT/GET
            return "redirect:/users/" + user.getId();

            // POST/FORWARD/GET
            // return "user/list";

        }




}
