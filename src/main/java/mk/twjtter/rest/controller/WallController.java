package mk.twjtter.rest.controller;

import mk.twjtter.entity.Post;
import mk.twjtter.rest.controller.dto.PostDTO;
import mk.twjtter.service.TwjtterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("wall")
public class WallController {

    private final TwjtterService twjtterService;

    @Autowired
    public WallController(TwjtterService twjtterService) {
        this.twjtterService = twjtterService;
    }

    @PostMapping
    public PostDTO addPost(@RequestParam(value="user") String user, @Valid @RequestBody Post newPost) {

        return new PostDTO(twjtterService.addPost(newPost, user));
    }

    @RequestMapping("/my")
    public List<PostDTO> myWall(@RequestParam(value="user") String user) {

        List<Post> postList = twjtterService.getWall(user);
        return postList.stream().map(p -> new PostDTO(p)).collect(Collectors.toList());
    }

    @RequestMapping
    public List<PostDTO> timeline(@RequestParam(value="user") String user) {

        List<Post> postList = twjtterService.getTimeline(user);
        return postList.stream().map(p -> new PostDTO(p)).collect(Collectors.toList());
    }

}
