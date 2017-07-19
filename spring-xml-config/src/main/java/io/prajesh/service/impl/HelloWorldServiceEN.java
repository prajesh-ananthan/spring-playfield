package io.prajesh.service.impl;

import io.prajesh.domain.impl.HelloWorldEn;
import io.prajesh.service.HelloWorldService;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
public class HelloWorldServiceEN implements HelloWorldService {

  private HelloWorldEn helloWorldEn;

  public HelloWorldEn getHelloWorldEn() {
    return helloWorldEn;
  }

  public void setHelloWorldEn(HelloWorldEn helloWorldEn) {
    this.helloWorldEn = helloWorldEn;
  }

  @Override
  public String getMessage() {
    return helloWorldEn.greeting();
  }
}
