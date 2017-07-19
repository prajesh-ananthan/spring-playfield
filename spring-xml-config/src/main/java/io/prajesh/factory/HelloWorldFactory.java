package io.prajesh.factory;

import io.prajesh.domain.HelloWorld;
import io.prajesh.domain.impl.HelloWorldDE;
import io.prajesh.domain.impl.HelloWorldEn;
import io.prajesh.domain.impl.HelloWorldEs;
import io.prajesh.domain.impl.HelloWorldMy;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
public class HelloWorldFactory {

  private static final String ENGLISH = "en";
  private static final String MALAY = "my";
  private static final String GERMAN = "de";
  private static final String SPANISH = "es";

  public HelloWorld getHelloWorldFactory(String language) {
    HelloWorld helloWorld = null;

    switch (language) {
      case ENGLISH:
        helloWorld = new HelloWorldEn();
        break;
      case MALAY:
        helloWorld = new HelloWorldMy();
        break;
      case GERMAN:
        helloWorld = new HelloWorldDE();
        break;
      case SPANISH:
        helloWorld = new HelloWorldEs();
        break;
      default:
        helloWorld = new HelloWorldEn();
    }
    return helloWorld;
  }
}
