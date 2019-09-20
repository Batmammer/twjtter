package mk.twjtter.service;

import mk.twjtter.entity.Post;
import mk.twjtter.entity.User;
import mk.twjtter.exception.CantFollowYourselfException;
import mk.twjtter.exception.UserNotFoundException;
import mk.twjtter.repository.PostRespository;
import mk.twjtter.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TwjtterService {
    private final UserRespository userRespository;
    private final PostRespository postRespository;

    @Autowired
    public TwjtterService(UserRespository userRespository, PostRespository postRespository) {
        this.userRespository = userRespository;
        this.postRespository = postRespository;
    }

    public Post addPost(Post post, String name) {
        User user = getUser(name);
        Post newPost = postRespository.save(new Post(post.getMessage(), user));
        return newPost;
    }

    private User getUser(String name) {
        Optional<User> optionalUser = userRespository.findOneByName(name);
        if (!optionalUser.isPresent()) {
            return userRespository.save(new User(name));
        }
        return optionalUser.get();
    }

    public List<Post> getWall(String name) {
        User user = userRespository.findOneByName(name).orElseThrow(() ->
                new UserNotFoundException("User not found " + name));
        return postRespository.findAllByUser_nameOrderByPublicationTimeDesc(user.getName());
    }

    public List<Post> getTimeline(String name) {
        User user = userRespository.findOneByName(name).orElseThrow(() ->
                new UserNotFoundException("User not found " + name));
        return postRespository.findAllByUser_nameInOrderByPublicationTimeDesc(
                user.getFollowing().stream().map(User::getName).collect(Collectors.toSet()));
    }

    public void follow(String userName, String userToFollow) {
        if (userName.equals(userToFollow)) {
            throw new CantFollowYourselfException("Can't follow yourself");
        }
        User user = userRespository.findOneByName(userName).orElseThrow(() ->
                new UserNotFoundException("User not found " + userName));
        User toFollow = userRespository.findOneByName(userToFollow).orElseThrow(() ->
                new UserNotFoundException("User not found " + userToFollow));
        user.addFollowing(toFollow);
    }

    public void unfollow(String userName, String userToUnfollow) {
        User user = userRespository.findOneByName(userName).orElseThrow(() ->
                new UserNotFoundException("User not found " + userName));
        User toUnfollow = userRespository.findOneByName(userToUnfollow).orElseThrow(() ->
                new UserNotFoundException("User not found " + userToUnfollow));
        user.removeFollowing(toUnfollow);
    }
}
