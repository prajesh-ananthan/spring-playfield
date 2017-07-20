package io.prajesh.controller;

import io.prajesh.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */

@RestController
public class GreetingController {
  private static final Logger LOG = LoggerFactory.getLogger(GreetingController.class);
  private HelloWorldService helloWorldService;
  private HelloWorldService helloWorldServiceEs;
  private HelloWorldService helloWorldServiceDe;

  public HelloWorldService getHelloWorldService() {
    return helloWorldService;
  }

  public void setHelloWorldService(HelloWorldService helloWorldService) {
    this.helloWorldService = helloWorldService;
  }

  public HelloWorldService getHelloWorldServiceEs() {
    return helloWorldServiceEs;
  }

  public void setHelloWorldServiceEs(HelloWorldService helloWorldServiceEs) {
    this.helloWorldServiceEs = helloWorldServiceEs;
  }

  public HelloWorldService getHelloWorldServiceDe() {
    return helloWorldServiceDe;
  }

  public void setHelloWorldServiceDe(HelloWorldService helloWorldServiceDe) {
    this.helloWorldServiceDe = helloWorldServiceDe;
  }

  @RequestMapping("/")
  public String sayHello() {
    LOG.info("Load by profile: " + helloWorldService.getMessage());
    LOG.info(helloWorldServiceDe.getMessage());
    LOG.info(helloWorldServiceEs.getMessage());

    return helloWorldService.getMessage() + "\n" +
        helloWorldServiceDe.getMessage() + "\n" +
        helloWorldServiceEs.getMessage();
  }
}
