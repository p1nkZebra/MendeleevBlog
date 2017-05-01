package controller;

import controller.service.UserService;
import dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        String message = "Welcome to Mendeleev Blog!";
        return new ModelAndView("index", "messageInView", message);
    }


    // show login-password form
    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String authorizationUser(ModelMap model) {
        model.addAttribute("userLoginPass", new User());
        return "auth/sign-in";
    }

    // check login-password
    @RequestMapping(value = "/auth-check", method = RequestMethod.POST)
    public String authCheck(@ModelAttribute("userLoginPass") User userLoginPass) {
        String login = userLoginPass.getLogin();
        String password = userLoginPass.getPassword();

        User user = userService.findUser(login, password);

        if ( user == null ) {
            return "auth/auth-fail";
        } else {
            return "redirect:/userList";
        }
    }

    // show user list
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String showAllUsers(ModelMap model) {

        List<User> allUsers = userService.findAll();
        model.addAttribute("users", allUsers);

        return "users/list";

    }





}
