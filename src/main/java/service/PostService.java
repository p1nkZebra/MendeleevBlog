package service;

import dal.PostDao;
import dao.Post;
import dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public void saveNewPost(Post post, User user) {

    }
}
