package io.prajesh.service.impl;

import io.prajesh.domain.Customer;
import io.prajesh.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Prajesh Ananthan
 *         Created on 23/7/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
  @Override
  public List<Customer> listCustomers() {
    return null;
  }

  @Override
  public Customer getCustomerById(Integer id) {
    return null;
  }

  @Override
  public Customer saveOrUpdateCustomer(Customer customer) {
    return null;
  }

  @Override
  public Customer removeCustomerById(Integer id) {
    return null;
  }
}
