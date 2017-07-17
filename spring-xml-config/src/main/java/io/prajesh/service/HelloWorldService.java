package io.prajesh.service;

import io.prajesh.domain.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
public class HelloWorldService {

  private HelloWorld helloWorld;

  public HelloWorld getHelloWorld() {
    return helloWorld;
  }

  @Autowired
  public void setHelloWorld(HelloWorld helloWorld) {
    this.helloWorld = helloWorld;
  }

  public String getMessaage() {
    return helloWorld.greeting();
  }
}
