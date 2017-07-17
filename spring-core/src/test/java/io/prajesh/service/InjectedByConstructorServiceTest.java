package io.prajesh.service;

import io.prajesh.service.constructor.InjectedByConstructorService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Prajesh Ananthan
 *         Created on 16/7/2017.
 */
public class InjectedByConstructorServiceTest {

  private HelloWorldService service;
  private InjectedByConstructorService injectedByConstructorService;

  @Before
  public void setUp() throws Exception {
    service = mock(HelloWorldService.class);
    injectedByConstructorService = new InjectedByConstructorService(service);
  }

  @Test
  public void testGetMessage() throws Exception {
    // Given
    when(service.sayHello()).thenReturn("Hello World");

    // When
    String message = injectedByConstructorService.getMessage();

    // Verify
    assertEquals(message, "Hello World");
  }
}