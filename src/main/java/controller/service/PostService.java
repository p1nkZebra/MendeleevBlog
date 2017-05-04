package controller.service;

import dal.PostDao;
import dao.Post;
import dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public void saveNewPost(Post post, User user) {

    }

    public List<Post> findAllPostByUser(User user) {
        Long userId = user.getId();
        return postDao.findByUserId(userId);
    }
}
