package io.prajesh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

  @Autowired
  public HelloWorldService() {

  }

  public void printHello() {
    System.out.println("Hello World");
  }

}
