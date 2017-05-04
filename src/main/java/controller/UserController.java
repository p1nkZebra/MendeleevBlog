package controller;

import controller.service.PostService;
import controller.service.UserService;
import dao.Post;
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

    @Autowired
    private PostService postService;


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

    // show user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String showUserInfo(@PathVariable("id") long id, ModelMap model) {

        User user = userService.findById(id);
        model.addAttribute("user", user);

        List<Post> posts = postService.findAllPostByUser(user);
        model.addAttribute("userPosts", posts);

        return "users/show";
    }

    // show update form
    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") long id, ModelMap model) {

        User user = userService.findById(id);

        model.addAttribute("userInfo", user);

        return "users/userUpdate";
    }

    // update user
    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("userInfo") User user) {
        System.out.println(user.toString());

        userService.update(user);

        return "redirect:/users/" + user.getId();
    }






}
