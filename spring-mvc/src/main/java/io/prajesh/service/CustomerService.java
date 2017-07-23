package io.prajesh.service;

import io.prajesh.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Prajesh Ananthan
 *         Created on 23/7/2017.
 */
@Service
public interface CustomerService {
  List<Customer> listCustomers();

  Customer getCustomerById(Integer id);

  Customer saveOrUpdateCustomer(Customer customer);

  void removeCustomerById(Integer id);
}
