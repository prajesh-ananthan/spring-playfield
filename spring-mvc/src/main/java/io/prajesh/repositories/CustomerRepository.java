package io.prajesh.repositories;

import io.prajesh.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Prajesh Ananthan
 *         Created on 17/8/2017.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
