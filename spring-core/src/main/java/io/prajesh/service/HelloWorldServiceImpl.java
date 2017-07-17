package io.prajesh.service;

import io.prajesh.domain.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Prajesh Ananthan
 *         Created on 16/7/2017.
 */

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

  private HelloWorld helloWorld;

  public HelloWorld getHelloWorld() {
    return helloWorld;
  }

  public void setHelloWorld(HelloWorld helloWorld) {
    this.helloWorld = helloWorld;
  }

  @Override
  public String sayHello() {
    return "Hello World";
  }

  public String getMessage() {
    return helloWorld.sayHello();
  }
}
