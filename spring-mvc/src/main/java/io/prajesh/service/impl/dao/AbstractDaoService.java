package io.prajesh.service.impl.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * @author Prajesh Ananthan
 *         Created on 30/7/2017.
 */
public abstract class AbstractDaoService {
  protected EntityManagerFactory emf;

  @PersistenceUnit
  public void setEmf(EntityManagerFactory emf) {
    this.emf = emf;
  }
}
