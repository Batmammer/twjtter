package mk.twjtter.rest.controller;

import mk.twjtter.service.TwjtterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("follow")
public class UserController {
    private  final TwjtterService twjtterService;

    public UserController(TwjtterService twjtterService) {
        this.twjtterService = twjtterService;
    }

    @PutMapping("/{userId}")
    public void follow(@PathVariable(name = "userId") String userId, @RequestParam(value="user") String user) {
        twjtterService.follow(user, userId);
    }

    @DeleteMapping("/{userId}")
    public void unfollow(@PathVariable(name = "userId") String userId, @RequestParam(value="user") String user) {
        twjtterService.unfollow(user, userId);
    }
}
