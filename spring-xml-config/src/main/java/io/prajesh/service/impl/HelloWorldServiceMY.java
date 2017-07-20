package io.prajesh.service.impl;

import io.prajesh.domain.impl.HelloWorldMy;
import io.prajesh.service.HelloWorldService;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
public class HelloWorldServiceMY implements HelloWorldService {


  private HelloWorldMy helloWorldMy;

  public HelloWorldMy getHelloWorldMy() {
    return helloWorldMy;
  }

  public void setHelloWorldMy(HelloWorldMy helloWorldMy) {
    this.helloWorldMy = helloWorldMy;
  }

  @Override
  public String getMessage() {
    return helloWorldMy.greeting();
  }
}