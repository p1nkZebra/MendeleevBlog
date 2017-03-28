package logic.service;

import dao.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.PostService;
import service.UserService;

@Ignore
public class PostServiceTest {

    @Autowired
    private PostService postService;

//    @Autowired
    private UserService userService = new UserService();

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void testSaveRecord() throws Exception {
        System.out.println("test");
//        User user = new User();
//        user.setFirstName("Alex");
//        user.setLastName("Brown");
//
//        userService.saveUser();
//        System.out.println(user.toString());

//        Post post = new Post();
//        post.setUser(user);
//        post.setTitle("тест");
//        post.setPublication("уруру");
//
//        Post dbPost = service.add(post);
//
//        System.out.println(dbPost);
    }


}