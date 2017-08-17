package io.prajesh.service.impl.reposervice;

import io.prajesh.constants.ProfileConfig;
import io.prajesh.domain.security.Role;
import io.prajesh.repositories.RoleRepository;
import io.prajesh.service.RoleService;
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
public class RoleServiceRepoImpl implements RoleService {

  private RoleRepository roleRepository;

  @Autowired
  public void setRoleRepository(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public List<?> list() {
    List<Role> roles = new ArrayList<>();
    roleRepository.findAll().forEach(roles::add);
    return roles;
  }

  @Override
  public Role findById(Integer id) {
    return roleRepository.findOne(id);
  }

  @Override
  public Role saveOrUpdate(Role domainObject) {
    return roleRepository.save(domainObject);
  }

  @Override
  public void remove(Integer id) {
    roleRepository.delete(id);
  }
}
