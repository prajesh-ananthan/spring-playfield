package io.prajesh.service.impl.dao;

import io.prajesh.domain.pojo.User;
import io.prajesh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Prajesh Ananthan
 *         Created on 30/7/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("jpadao")
public class UserServiceDaoTest {

  private UserService userService;
  private Logger LOG = LoggerFactory.getLogger(UserServiceDaoTest.class);

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @Test
  public void testSaveOrUpdateUser() throws Exception {
    final String username = "prajesh";
    final String password = "password";
    User user = new User();

    user.setUserName(username);
    user.setPassword(password);

    User savedUser = userService.saveOrUpdate(user);

    assertEquals(savedUser.getUserName(), username);
    assertNotNull(user.getEncryptedPassword());
    System.out.println("Encrypted password:: " + user.getEncryptedPassword());
  }
}