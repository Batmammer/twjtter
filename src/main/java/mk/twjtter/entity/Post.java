package mk.twjtter.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="posts")
public class Post implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="message")
    @NotEmpty(message = "Please provide a message")
    @Size(max = 140, message = "Maximum message length is 140 characters")
    private String message;

    @Column(name="publication_time")
    private LocalDateTime publicationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_name")
    private User user;

    public Post(String message, User user) {
        this.user = user;
        this.message = message;
        this.publicationTime = LocalDateTime.now();
    }

    public Post() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(LocalDateTime publicationTime) {
        this.publicationTime = publicationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
