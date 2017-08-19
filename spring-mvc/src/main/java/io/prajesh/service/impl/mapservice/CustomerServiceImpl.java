package io.prajesh.service.impl.mapservice;

import io.prajesh.commands.CustomerForm;
import io.prajesh.constants.ProfileConfig;
import io.prajesh.converters.CustomerFormToCustomer;
import io.prajesh.domain.Customer;
import io.prajesh.domain.DomainObject;
import io.prajesh.service.CustomerService;
import io.prajesh.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Prajesh Ananthan
 *         Created on 23/7/2017.
 */
@Service
@Profile(ProfileConfig.MAP)
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

  private CustomerFormToCustomer customerFormToCustomer;

  public CustomerServiceImpl() throws IOException {
  }

  @Autowired
  public void setCustomerFormToCustomer(CustomerFormToCustomer customerFormToCustomer) {
    this.customerFormToCustomer = customerFormToCustomer;
  }

  @Override
  protected void loadDomainObjectsFromJSON() throws IOException {
    List<Customer> customerList = JsonUtils.convertJsonToCustomerPojo(CUSTOMERS_JSON_FILE);
    domainMap = customerList.stream().collect(Collectors.toMap(c -> c.getId(), c -> c));
  }

  @Override
  public List<DomainObject> list() {
    return super.listAll();
  }

  @Override
  public Customer findById(Integer id) {
    return (Customer) super.getById(id);
  }

  @Override
  public Customer saveOrUpdate(Customer domainObject) {
    return (Customer) super.saveOrUpdate(domainObject);
  }

  @Override
  public void remove(Integer id) {
    super.delete(id);
  }

  @Override
  public Customer saveOrUpdateCustomerForm(CustomerForm customerForm) {
    Customer newCustomer = customerFormToCustomer.convert(customerForm);
    if (newCustomer.getUser().getId() != null) {
      Customer existingCustomer = findById(newCustomer.getId());
      newCustomer.getUser().setEnabled(existingCustomer.getUser().getEnabled());
    }
    return newCustomer;
  }
}
