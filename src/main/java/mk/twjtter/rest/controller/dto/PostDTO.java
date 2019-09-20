package mk.twjtter.rest.controller.dto;

import mk.twjtter.entity.Post;

import java.time.LocalDateTime;

public class PostDTO {
    private String message;
    private LocalDateTime time;
    private String user;

    public PostDTO(Post post) {
        this.message = post.getMessage();
        this.time = post.getPublicationTime();
        this.user = post.getUser().getName();
    }

    public PostDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
