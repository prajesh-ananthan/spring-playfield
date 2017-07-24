package io.prajesh.controller;

import com.google.common.annotations.VisibleForTesting;
import io.prajesh.domain.pojo.Customer;
import io.prajesh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Prajesh Ananthan
 *         Created on 23/7/2017.
 */
@Controller
public class CustomerController {

  @VisibleForTesting
  static final String CUSTOMER = "customer";
  @VisibleForTesting
  static final String CUSTOMER_PAGE = CUSTOMER + "/" + CUSTOMER;
  @VisibleForTesting
  static final String CUSTOMERS = "customers";
  @VisibleForTesting
  static final String CUSTOMERS_PAGE = CUSTOMER + "/" + CUSTOMERS;

  private static final String CUSTOMER_FORM = CUSTOMER + "/customer-form";
  private static final String REDIRECT_CUSTOMERS = "redirect:/" + CUSTOMERS + "/";
  private static final String REDIRECT_CUSTOMER_PAGE = "redirect:/" + CUSTOMER + "/";
  private CustomerService customerService;

  @Autowired
  public void setCustomerService(CustomerService customerService) {
    this.customerService = customerService;
  }

  @RequestMapping(value = "/customers")
  public String listCustomers(Model model) {
    List<Customer> customers = (List<Customer>) customerService.list();
    model.addAttribute("customers", customers);
    return CUSTOMERS_PAGE;
  }

  @RequestMapping(value = "/customer/{id}")
  public String findCustomerById(@PathVariable Integer id, Model model) {
    Customer customer = customerService.findById(id);
    model.addAttribute("customer", customer);
    return CUSTOMER_PAGE;
  }

  @RequestMapping("/customer/new")
  public String createNewCustomer(Model model) {
    model.addAttribute("customer", new Customer());
    return CUSTOMER_FORM;
  }

  @RequestMapping("/customer/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    Customer customer = customerService.findById(id);
    model.addAttribute("customer", customer);
    return CUSTOMER_FORM;
  }

  @RequestMapping("/customer/remove/{id}")
  public String delete(@PathVariable Integer id, Model model) {
    customerService.remove(id);
    return REDIRECT_CUSTOMERS;
  }

  @RequestMapping(value = "/customer", method = RequestMethod.POST)
  public String createOrUpdateProduct(Customer customer) {
    Customer savedCustomer = customerService.saveOrUpdate(customer);
    return REDIRECT_CUSTOMER_PAGE + savedCustomer.getId();
  }
}
