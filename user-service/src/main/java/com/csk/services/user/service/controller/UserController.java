package com.csk.services.user.service.controller;

import com.csk.services.user.service.VO.ResponseTemplateVO;
import com.csk.services.user.service.entity.User;
import com.csk.services.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController......");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUser(@PathVariable("id") Long userId,
                                      @RequestParam("time") Long time) {
        log.info("Inside getUser of UserController......");
        return userService.getUser(userId, time);
    }
}
