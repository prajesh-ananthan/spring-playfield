package io.prajesh.controller;

import io.prajesh.domain.User;
import io.prajesh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Prajesh Ananthan
 *         Created on 9/8/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {

  static final String USERS = "users";
  static final String USER = "user";
  static final String REDIRECT_USER_PAGE = "redirect:/" + USER + "/";
  static final String USER_FORM = "user/user-form";
  static final String USER_PAGE = "user/user";
  static final String USERS_PAGE = "user/users";
  private UserService userService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/list")
  public String listCustomers(Model model) {
    model.addAttribute(USERS, userService.list());
    return USERS_PAGE;
  }

  @GetMapping("/{id}")
  public String findUserById(@PathVariable Integer id, Model model) {
    model.addAttribute(USER, userService.findById(id));
    return USER_PAGE;
  }

  @GetMapping("/new")
  public String createNewUser(Model model) {
    model.addAttribute(USER, new User());
    return USER_FORM;
  }

  @PutMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    model.addAttribute(USER, userService.findById(id));
    return USER_FORM;
  }

  @PostMapping(value = "/")
  public String createOrUpdateUser(User user) {
    User savedUser = userService.saveOrUpdate(user);
    return REDIRECT_USER_PAGE + savedUser.getId();
  }
}
