package io.prajesh.controller;

import io.prajesh.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
public class GreetingController {

  HelloWorldService helloWorldService;
  HelloWorldService helloWorldServiceEn;

  public HelloWorldService getHelloWorldService() {
    return helloWorldService;
  }

  @Autowired
  public void setHelloWorldService(HelloWorldService helloWorldService) {
    this.helloWorldService = helloWorldService;
  }

  @RequestMapping("/")
  public String message() {
    return helloWorldService.getMessaage();
  }
}
