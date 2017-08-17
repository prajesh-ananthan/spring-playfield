package io.prajesh.service.impl.reposervice;

import io.prajesh.constants.ProfileConfig;
import io.prajesh.domain.Order;
import io.prajesh.repositories.OrderRespository;
import io.prajesh.service.OrderService;
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
public class OrderServiceRepoImpl implements OrderService {
  private OrderRespository orderRespository;

  @Autowired
  public void setOrderRespository(OrderRespository orderRespository) {
    this.orderRespository = orderRespository;
  }

  @Override
  public List<?> list() {
    List<Order> orders = new ArrayList<>();
    orderRespository.findAll().forEach(orders::add);
    return orders;
  }

  @Override
  public Order findById(Integer id) {
    return orderRespository.findOne(id);
  }

  @Override
  public Order saveOrUpdate(Order domainObject) {
    return orderRespository.save(domainObject);
  }

  @Override
  public void remove(Integer id) {
    orderRespository.delete(id);
  }
}
