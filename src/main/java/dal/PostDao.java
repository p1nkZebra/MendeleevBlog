package dal;

import dao.Post;

import java.util.List;

public interface PostDao {
    void save(Post entity);

    Post findSinglePostByPostId(Long userId);

    Post findSinglePostByPostIdAndUserId(Long postId, Long userId);

    String findPublicationByPostId(Long postId);

    List<Post> findAll();
}
