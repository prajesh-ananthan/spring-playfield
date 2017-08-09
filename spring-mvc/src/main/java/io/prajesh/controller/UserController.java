package io.prajesh.controller;

import io.prajesh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Prajesh Ananthan
 *         Created on 9/8/2017.
 */
@Controller
public class UserController {

  private static final String USERS = "users";
  private static final String USER = "user";
  private UserService userService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/users")
  public String listCustomers(Model model) {
    model.addAttribute(USERS, userService.list());
    return "user/users";
  }

}
