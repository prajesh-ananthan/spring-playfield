package io.prajesh.service.impl.reposervice;

import io.prajesh.constants.ProfileConfig;
import io.prajesh.domain.User;
import io.prajesh.repositories.UserRepository;
import io.prajesh.service.UserService;
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
public class UserServiceRepoImpl implements UserService {
  UserRepository userRepository;

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<?> list() {
    List<User> users = new ArrayList<>();
    userRepository.findAll().forEach(users::add);
    return users;
  }

  @Override
  public User findById(Integer id) {
    return userRepository.findOne(id);
  }

  @Override
  public User saveOrUpdate(User domainObject) {
    return userRepository.save(domainObject);
  }

  @Override
  public void remove(Integer id) {
    userRepository.delete(id);
  }
}
