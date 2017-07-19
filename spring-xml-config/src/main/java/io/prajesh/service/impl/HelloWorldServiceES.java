package io.prajesh.service.impl;

import io.prajesh.domain.impl.HelloWorldEs;
import io.prajesh.service.HelloWorldService;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
public class HelloWorldServiceES implements HelloWorldService {

  private HelloWorldEs helloWorldEs;

  public HelloWorldEs getHelloWorldEs() {
    return helloWorldEs;
  }

  public void setHelloWorldEs(HelloWorldEs helloWorldEs) {
    this.helloWorldEs = helloWorldEs;
  }

  @Override
  public String getMessage() {
    return helloWorldEs.greeting();
  }
}
