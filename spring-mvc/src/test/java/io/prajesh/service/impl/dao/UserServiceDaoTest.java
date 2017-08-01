package io.prajesh.service.impl.dao;

import io.prajesh.domain.pojo.Customer;
import io.prajesh.domain.pojo.User;
import io.prajesh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
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
  private User user;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
    user = new User();
    user.setUserName("prajesh");
    user.setPassword("password");
  }

  @Test
  public void testSaveOrUpdateUser() throws Exception {
    // Given

    // When
    User savedUser = userService.saveOrUpdate(user);

    // Verify
    assertEquals(savedUser.getUserName(), "prajesh");
    assertNotNull(user.getEncryptedPassword());
    System.out.println("Encrypted password ==> " + user.getEncryptedPassword());
  }

  @Test
  public void testSaveOfUserWithCustomer() throws Exception {
    // Given
    Customer customer = new Customer();
    customer.setFirstName("Prajesh");
    customer.setLastName("Ananthan");
    user.setCustomer(customer);

    // When
    User savedUser = userService.saveOrUpdate(user);

    // Verify
    assertNotNull(savedUser.getId());
    assert savedUser.getCustomer().getId() != null;
  }
}