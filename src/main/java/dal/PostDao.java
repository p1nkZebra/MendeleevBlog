package dal;

import dao.Post;
import org.joda.time.LocalDateTime;

import java.util.List;

public interface PostDao {
    void save(Post entity);

    Post findSinglePostByPostIdAndUserId(Long postId, Long userId);

    String findPublicationByPostId(Long postId);

    List<Post> findAll();

    List<Post> findFirstFifty();

    List<Post> findFirstFiftyForPeriod(LocalDateTime startPeriod, LocalDateTime endPeriod);

    Post findById(Long publicationId);

    List<Post> findByUserId(Long userId);
}
