package com.rbanos.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbanos.user.VO.ResponseTemplateVO;
import com.rbanos.user.entity.User;
import com.rbanos.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/")
  public User saveUser(@RequestBody User user) {
    log.info("Inside UserController.saveUser");
    return userService.saveUser(user);
  }

  @GetMapping("/{id}")
  public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
    log.info("Inside UserController.getUserWithDepartment");
    return userService.getUserWithDepartment(userId);
  }

}
