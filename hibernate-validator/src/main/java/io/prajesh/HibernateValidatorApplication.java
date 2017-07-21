package io.prajesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.prajesh.services.HelloWorldService;

@SpringBootApplication
public class HibernateValidatorApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(HibernateValidatorApplication.class, args);
    HelloWorldService helloWorldService = (HelloWorldService) ctx.getBean("helloWorldService");
    helloWorldService.printHello();
  }
}
