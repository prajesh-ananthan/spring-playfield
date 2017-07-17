package io.prajesh.service.constructor;

import io.prajesh.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Prajesh Ananthan
 *         Created on 16/7/2017.
 */
@Service
public class InjectedByConstructorService {

  private HelloWorldService helloWorldService;

  @Autowired
  public InjectedByConstructorService(HelloWorldService helloWorldService) {
    this.helloWorldService = helloWorldService;
  }

  public String getMessage() {
    return helloWorldService.sayHello();
  }
}
