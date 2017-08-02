package io.prajesh.service.impl.dao;

import io.prajesh.domain.*;
import io.prajesh.service.ProductService;
import io.prajesh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Prajesh Ananthan
 *         Created on 30/7/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(AbstractDaoService.JPA_DAO)
public class UserServiceDaoTest {

  private UserService userService;
  private ProductService productService;
  private User user;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
    user = new User();
    user.setUserName("prajesh");
    user.setPassword("password");
  }

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
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

  @Test
  public void testAddCartOnUser() throws Exception {
    // Given
    User user = new User();
    user.setUserName("john doe");
    user.setPassword("password");

    user.setCart(new Cart());

    // When
    User savedUser = userService.saveOrUpdate(user);

    // Verify
    assertNotNull(savedUser.getId());
    assertNotNull(savedUser.getCart());
  }

  @Test
  public void testAddCartToUserWithCartDetails() throws Exception {
    // Given
    User user = new User();
    user.setUserName("john doe");
    user.setPassword("password");
    // Set the cart for user
    user.setCart(new Cart());
    // Get the products
    List<Product> products = (List<Product>) productService.list();

    // Add product into CartDetail, Add CartDetail into Cart
    CartDetail cartItemOne = new CartDetail();
    cartItemOne.setProduct(products.get(0));
    user.getCart().addCartDetail(cartItemOne);

    CartDetail cartItemTwo = new CartDetail();
    cartItemTwo.setProduct(products.get(1));
    user.getCart().addCartDetail(cartItemTwo);

    // When
    User savedUser = userService.saveOrUpdate(user);

    // Verify
    assertNotNull(savedUser.getCart());
    assertNotNull(savedUser.getCart().getId()); // TODO: No id for cart
    assertNotNull(savedUser.getCart().getCartDetails());
  }
}