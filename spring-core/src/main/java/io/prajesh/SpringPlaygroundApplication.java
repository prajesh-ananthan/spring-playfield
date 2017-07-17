package io.prajesh;

import io.prajesh.domain.HelloWorld;
import io.prajesh.domain.HelloWorldEn;
import io.prajesh.service.HelloWorldServiceImpl;
import io.prajesh.service.factory.HelloWorldFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringPlaygroundApplication {

  private static final Logger log = LoggerFactory.getLogger(SpringPlaygroundApplication.class);

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SpringPlaygroundApplication.class, args);

    /*InjectedByConstructorService injectedByConstructorService = (InjectedByConstructorService) ctx.getBean("injectedByConstructorService");
    log.info("InjectedByConstructorService: " + injectedByConstructorService.getMessage());

    SetterBasedService setterBasedService = (SetterBasedService) ctx.getBean("setterBasedService");
    log.info("SetterBasedService: " + setterBasedService.getMessage());*/

    // Java configuration
    HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorldEn");
    System.out.println(helloWorld.sayHello());
  }
}
