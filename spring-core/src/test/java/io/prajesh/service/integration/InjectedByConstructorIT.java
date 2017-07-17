package io.prajesh.service.integration;

import io.prajesh.service.constructor.InjectedByConstructorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Prajesh Ananthan
 *         Created on 16/7/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InjectedByConstructorIT {

  @Autowired
  InjectedByConstructorService injectedByConstructorService;

  @Test
  public void testGetMessage() throws Exception {
    // Given

    // When
    String message = injectedByConstructorService.getMessage();

    // Verify
    assertEquals(message, "Hello World");
  }
}
