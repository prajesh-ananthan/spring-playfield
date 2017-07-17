package io.prajesh.domain;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author Prajesh Ananthan
 *         Created on 16/7/2017.
 */
//@Component
//@Profile("Malay")
public class HelloWorldMy implements HelloWorld {

  private String message = "Hai Dunia!";

  @Override
  public String sayHello() {
    return message;
  }
}
