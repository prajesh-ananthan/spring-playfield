package io.prajesh.config;

import io.prajesh.service.HelloWorldService;
import io.prajesh.service.impl.HelloWorldServiceEN;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Prajesh Ananthan
 *         Created on 17/7/2017.
 */
@Configuration
public class HelloConfig {
//    @Bean
//    public HelloWorld helloWorldImpl() {
//      return new HelloWorldImpl();
//    }

//    @Bean
//    public HelloWorldFactory helloWorldFactory() {
//      return new HelloWorldFactory();
//    }

  @Bean
  public HelloWorldService helloWorldService() {
    return new HelloWorldServiceEN();
  }

//    @Bean
//    @Profile("English")
//    public HelloWorld helloWorldEn(HelloWorldFactory factory) {
//      return factory.getHelloWorldFactory("en");
//    }

//    @Bean
//    @Profile("Malay")
//    public HelloWorld helloWorldMy(HelloWorldFactory factory) {
//      return factory.getHelloWorldFactory("my");
//    }
}
