package io.prajesh.domain.impl;

import io.prajesh.domain.HelloWorld;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
public class HelloWorldEs implements HelloWorld {

  @Override
  public String greeting() {
    return "Hola Mundo!";
  }
}
