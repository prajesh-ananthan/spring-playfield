package io.prajesh.domain;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author Prajesh Ananthan
 *         Created on 16/7/2017.
 */
//@Component
//@Profile("default")
public class HelloWorldEn implements HelloWorld {

  private String message = "Hello World";

  @Override
  public String sayHello() {
    return message;
  }
}
