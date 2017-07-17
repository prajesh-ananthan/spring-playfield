package io.prajesh.domain.impl;

import io.prajesh.domain.HelloWorld;
import org.springframework.stereotype.Component;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
public class HelloWorldMy implements HelloWorld {
  @Override
  public String greeting() {
    return "Hai Dunia!";
  }
}
