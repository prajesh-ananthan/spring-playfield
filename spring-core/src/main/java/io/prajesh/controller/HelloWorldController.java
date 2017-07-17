package io.prajesh.controller;

import io.prajesh.domain.HelloWorld;
import io.prajesh.service.HelloWorldServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Prajesh Ananthan
 *         Created on 16/7/2017.
 */
//@RestController
public class HelloWorldController {

//  @Autowired
  private HelloWorld helloWorld;

//  @Autowired
  private HelloWorldServiceImpl service;

  @RequestMapping("/")
  public String helloWorld() {
    service.setHelloWorld(helloWorld);
    return service.getMessage();
  }
}
