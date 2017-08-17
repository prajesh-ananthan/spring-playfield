package io.prajesh.service.impl.reposervice;

import io.prajesh.constants.ProfileConfig;
import io.prajesh.domain.Customer;
import io.prajesh.repositories.CustomerRepository;
import io.prajesh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Prajesh Ananthan
 *         Created on 17/8/2017.
 */
@Service
@Profile(ProfileConfig.SPRING_DATA_JPA)
public class CustomerServiceRepoImpl implements CustomerService {

  private CustomerRepository customerRepository;

  @Autowired
  public void setCustomerRepository(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public List<?> list() {
    List<Customer> customers = new ArrayList<>();
    customerRepository.findAll().forEach(customers::add);
    return customers;
  }

  @Override
  public Customer findById(Integer id) {
    return customerRepository.findOne(id);
  }

  @Override
  public Customer saveOrUpdate(Customer domainObject) {
    return customerRepository.save(domainObject);
  }

  @Override
  public void remove(Integer id) {
    customerRepository.delete(id);
  }
}
