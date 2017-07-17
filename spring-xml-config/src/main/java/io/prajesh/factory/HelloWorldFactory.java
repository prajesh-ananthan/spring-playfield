package io.prajesh.factory;

import io.prajesh.domain.HelloWorld;
import io.prajesh.domain.impl.HelloWorldEn;
import io.prajesh.domain.impl.HelloWorldMy;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
public class HelloWorldFactory {
  public HelloWorld getHelloWorldFactory(String language) {
    HelloWorld helloWorld = null;

    switch (language) {
      case "en":
        helloWorld = new HelloWorldEn();
        break;
      case "my":
        helloWorld = new HelloWorldMy();
        break;
      default:
        helloWorld = new HelloWorldEn();
    }
    return helloWorld;
  }
}
