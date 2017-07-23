package io.prajesh.service.impl;

import io.prajesh.domain.DomainObject;
import io.prajesh.domain.pojo.Customer;
import io.prajesh.service.AbstractMapService;
import io.prajesh.service.CustomerService;
import io.prajesh.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Prajesh Ananthan
 *         Created on 23/7/2017.
 */
@Service
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

  private static final String CUSTOMERS_JSON_FILE = "json/customers.json";
  private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

  public CustomerServiceImpl() throws IOException {
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
}
