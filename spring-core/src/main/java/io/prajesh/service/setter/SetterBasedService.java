package io.prajesh.service.setter;

import io.prajesh.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Prajesh Ananthan
 *         Created on 16/7/2017.
 */
@Service
public class SetterBasedService {

  private HelloWorldService helloWorldService;

  public String getMessage() {
    return helloWorldService.sayHello();
  }

  public HelloWorldService getHelloWorldService() {
    return helloWorldService;
  }

  @Autowired
  public void setHelloWorldService(HelloWorldService helloWorldService) {
    this.helloWorldService = helloWorldService;
  }
}
