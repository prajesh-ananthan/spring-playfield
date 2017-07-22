package io.prajesh.controller;

import io.prajesh.domain.Customer;
import io.prajesh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Prajesh Ananthan
 *         Created on 23/7/2017.
 */
@Controller
public class CustomerController {

  private static final String CUSTOMERS = "customer/customers";
  private CustomerService customerService;

  @Autowired
  public void setCustomerService(CustomerService customerService) {
    this.customerService = customerService;
  }

  /*
  * TODO:
  * 1) Insert content in json file
  * 2) Update the service
  * 3) Create template
  * */
  @RequestMapping(value = "/customers")
  public String listCustomers(Model model) {
    List<Customer> customers = customerService.listCustomers();
    model.addAttribute("customers", customers);
    return CUSTOMERS;
  }


}
