package io.prajesh.config;

import io.prajesh.domain.HelloWorld;
import io.prajesh.service.HelloWorldService;
import io.prajesh.service.HelloWorldServiceImpl;
import io.prajesh.service.factory.HelloWorldFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Prajesh Ananthan
 *         Created on 16/7/2017.
 */
@Configuration
public class HelloConfig {

  @Bean
  public HelloWorldFactory helloWorldFactory() {
    return new HelloWorldFactory();
  }

  @Bean
  public HelloWorldService helloWorldService() {
    return new HelloWorldServiceImpl();
  }

  @Bean
  @Profile("English")
  public HelloWorld helloWorldEn(HelloWorldFactory factory) {
    return factory.getHelloWorldFactory("en");
  }

  @Bean
  @Profile("Malay")
  public HelloWorld helloWorldMy(HelloWorldFactory factory) {
    return factory.getHelloWorldFactory("my");
  }
}
