package io.prajesh.service.impl;

import io.prajesh.domain.Customer;
import io.prajesh.service.CustomerService;
import io.prajesh.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Prajesh Ananthan
 *         Created on 23/7/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

  private static final String CUSTOMERS_JSON_FILE = "json/customers.json";
  private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);
  private Map<Integer, Customer> customers;

  public CustomerServiceImpl() throws IOException {
    loadCustomers();
  }

  @Override
  public List<Customer> listCustomers() {
    return new ArrayList<>(customers.values());
  }

  @Override
  public Customer getCustomerById(Integer id) {
    for (Customer customer : customers.values()) {
      if (id == customer.getId()) {
        return customer;
      }
    }
    LOG.error("Unable to find customer id: " + id);
    return null;
  }

  @Override
  public Customer saveOrUpdateCustomer(Customer customer) {
    if (customer != null) {
      if (customer.getId() == null) {
        customer.setId(getNextKey());
      }
      customers.put(customer.getId(), customer);
    } else {
      LOG.error("Customer cannot be null!");
      throw new RuntimeException("Customer cannot be null");
    }
    return customer;
  }

  private Integer getNextKey() {
    if (!CollectionUtils.isEmpty(customers.keySet())) {
      return Collections.max(customers.keySet()) + 1;
    }
    return 1;
  }

  @Override
  public void removeCustomerById(Integer id) {
    for (Customer customer : customers.values()) {
      if (id == customer.getId()) {
        customers.remove(customer.getId());
        return;
      } else {
        LOG.error("Customer with id: " + id + "not found!");
      }
    }
  }

  public void loadCustomers() throws IOException {
    List<Customer> customerList = JsonUtils.convertJsonToCustomerPojo(CUSTOMERS_JSON_FILE);
    customers = customerList.stream().collect(Collectors.toMap(c -> c.getId(), c -> c));
  }
}
