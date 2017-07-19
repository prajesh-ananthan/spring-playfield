package io.prajesh.service.impl;

import io.prajesh.domain.impl.HelloWorldDE;
import io.prajesh.service.HelloWorldService;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
public class HelloWorldServiceDE implements HelloWorldService {

  private HelloWorldDE helloWorldDe;

  public HelloWorldDE getHelloWorldDe() {
    return helloWorldDe;
  }

  public void setHelloWorldDe(HelloWorldDE helloWorldDe) {
    this.helloWorldDe = helloWorldDe;
  }

  @Override
  public String getMessage() {
    return helloWorldDe.greeting();
  }
}
