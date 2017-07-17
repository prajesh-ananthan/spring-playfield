package io.prajesh.service;

import io.prajesh.service.setter.SetterBasedService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Prajesh Ananthan
 *         Created on 16/7/2017.
 */
public class SetterBasedServiceTest {

  private HelloWorldService service;
  private SetterBasedService setterBasedService;

  @Before
  public void setUp() throws Exception {
    service = mock(HelloWorldService.class);
    setterBasedService = new SetterBasedService();
  }

  @Test
  public void testGetMessage() throws Exception {
    // Given
    when(service.sayHello()).thenReturn("Hello World");
    setterBasedService.setHelloWorldService(service);

    // When
    String message = setterBasedService.getMessage();

    // Verify
    assertEquals(message, "Hello World");
  }
}