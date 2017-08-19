package io.prajesh.helper;

import io.prajesh.commands.CustomerForm;
import io.prajesh.domain.Customer;

/**
 * @author Prajesh Ananthan
 *         Created on 18/8/2017.
 */
public class SpringJPAHelper {
  public static CustomerForm convertCustomerToCustomerForm(Customer customer) {
    CustomerForm customerForm = new CustomerForm();
    customerForm.setCustomerId(customer.getId());
    customerForm.setCustomerVersion(customer.getVersion());
    customerForm.setEmail(customer.getEmail());
    customerForm.setFirstName(customer.getFirstName());
    customerForm.setLastName(customer.getLastName());
    customerForm.setPhoneNumber(customer.getPhoneNumber());
    customerForm.setUserId(customer.getUser().getId());
    customerForm.setUserName(customer.getUser().getUserName());
    customerForm.setUserVersion(customer.getUser().getVersion());
    return customerForm;
  }
}
