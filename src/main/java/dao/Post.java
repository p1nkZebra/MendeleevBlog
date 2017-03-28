package dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "POST", schema = "JAVA_TASK")
public class Post {
    private long id;
    private User user;
    private String title;
    private String publication;

    public Post() {
    }

    public Post(long id, User user, String title, String publication) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.publication = publication;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "TITLE", length = 100, nullable = false, unique = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "PUBLICATION", length = 500, nullable = false, unique = false)
    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("user", user)
                .append("title", title)
                .append("publication", publication)
                .toString();
    }
}
