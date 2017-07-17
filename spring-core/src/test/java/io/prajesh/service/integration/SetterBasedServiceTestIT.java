package io.prajesh.service.integration;

import io.prajesh.service.HelloWorldService;
import io.prajesh.service.setter.SetterBasedService;
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
public class SetterBasedServiceTestIT {

  @Autowired
  SetterBasedService setterBasedService;

  @Autowired
  HelloWorldService service;

  @Test
  public void testGetMessage() throws Exception {
    // Given
    setterBasedService.setHelloWorldService(service);

    // When
    String message = setterBasedService.getMessage();

    // Given
    assertEquals(message, "Hello World");
  }
}