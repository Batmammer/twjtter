package mk.twjtter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @Column(name="name")
    private String name;

    @ManyToMany
    @JoinTable(name="tbl_following",
            joinColumns=@JoinColumn(name="name"),
            inverseJoinColumns=@JoinColumn(name="followName")
    )
    private Set<User> following;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }

    public void addFollowing(User user) {
        if (this.following == null) {
            this.following = new HashSet<>();
        }
        if (!this.following.contains(user)) {
            this.following.add(user);
        }
    }

    public void removeFollowing(User user) {
        if (this.following != null && this.following.contains(user)) {
            this.following.remove(user);
        }
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }
}
