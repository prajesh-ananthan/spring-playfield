package io.prajesh.controller;

import io.prajesh.domain.pojo.Customer;
import io.prajesh.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Prajesh Ananthan
 *         Created on 25/7/2017.
 */
public class CustomerControllerTest {

  @Mock
  private CustomerService customerService;

  @InjectMocks
  private CustomerController controller; // setups the controller, and inject mock objects into it

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this); // //initilizes controller and mocks
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void testListCustomers() throws Exception {
    // Given
    final List<Customer> customers = Arrays.asList(new Customer(), new Customer());

    when(customerService.list()).thenReturn((List) customers);

    // Verify
    mockMvc.perform(get("/customers"))
        .andExpect(status().isOk())
        .andExpect(view().name(CustomerController.CUSTOMERS_PAGE))
        .andExpect(model().attribute(CustomerController.CUSTOMERS, hasSize(2)));

  }

  @Test
  public void testShowCustomer() throws Exception {

    // Given
    final Integer id = 1;
    when(customerService.findById(id)).thenReturn(new Customer());

    // Verify
    mockMvc.perform(get("/customer/1"))
        .andExpect(status().isOk())
        .andExpect(view().name(CustomerController.CUSTOMER_PAGE))
        .andExpect(model().attribute(CustomerController.CUSTOMER, instanceOf(Customer.class)));

  }
}