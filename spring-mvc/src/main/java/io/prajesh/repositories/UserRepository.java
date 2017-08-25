package io.prajesh.repositories;

import io.prajesh.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Prajesh Ananthan
 *         Created on 17/8/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
  // Spring Data JPA is going to create the query for us
  User findByUserName(String userName);
}
