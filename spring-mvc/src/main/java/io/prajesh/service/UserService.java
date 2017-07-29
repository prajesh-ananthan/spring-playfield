package io.prajesh.service;

import io.prajesh.domain.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author Prajesh Ananthan
 *         Created on 30/7/2017.
 */
@Service
public interface UserService extends CRUDService<User> {
}
