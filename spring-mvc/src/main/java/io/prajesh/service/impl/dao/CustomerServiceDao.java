package io.prajesh.service.impl.dao;

import io.prajesh.domain.pojo.Customer;
import io.prajesh.service.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by ANAN011 on 27/7/2017.
 *
 * @author Prajesh Ananthan, arvato Systems Malaysia Sdn Bhd
 */
@Service
@Profile("jpadao")
public class CustomerServiceDao implements CustomerService {
  private EntityManagerFactory emf;

  public EntityManagerFactory getEmf() {
    return emf;
  }

  @PersistenceUnit
  public void setEmf(EntityManagerFactory emf) {
    this.emf = emf;
  }

  @Override
  public List<?> list() {
    EntityManager em = emf.createEntityManager();
    return em.createQuery("from Customer", Customer.class).getResultList();
  }

  @Override
  public Customer findById(Integer id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Customer.class, id);
  }

  @Override
  public Customer saveOrUpdate(Customer domainObject) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Customer savedCustomer = em.merge(domainObject);
    em.getTransaction().commit();

    return savedCustomer;
  }

  @Override
  public void remove(Integer id) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Customer deleteCustomer = em.find(Customer.class, id);
    em.remove(deleteCustomer);
    em.getTransaction().commit();
  }
}
