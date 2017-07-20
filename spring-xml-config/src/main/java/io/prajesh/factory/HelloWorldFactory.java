package io.prajesh.factory;

import io.prajesh.service.HelloWorldService;
import io.prajesh.service.impl.HelloWorldServiceDE;
import io.prajesh.service.impl.HelloWorldServiceEN;
import io.prajesh.service.impl.HelloWorldServiceES;
import io.prajesh.service.impl.HelloWorldServiceMY;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
public class HelloWorldFactory {

  private static final String ENGLISH = "en";
  private static final String MALAY = "my";
  private static final String GERMAN = "de";
  private static final String SPANISH = "es";

  public HelloWorldService createHelloWorldService(String language) {
    HelloWorldService helloWorldService = null;

    switch (language) {
      case ENGLISH:
        helloWorldService = new HelloWorldServiceEN();
        break;
      case MALAY:
        helloWorldService = new HelloWorldServiceMY();
        break;
      case GERMAN:
        helloWorldService = new HelloWorldServiceDE();
        break;
      case SPANISH:
        helloWorldService = new HelloWorldServiceES();
        break;
      default:
        helloWorldService = new HelloWorldServiceEN();
    }
    return helloWorldService;
  }
}