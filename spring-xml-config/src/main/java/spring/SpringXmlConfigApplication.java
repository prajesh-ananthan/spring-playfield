package spring;

import io.prajesh.domain.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Loads the appropriate bean based on the profile set in property file
 */
@SpringBootApplication
@ImportResource("classpath:/spring/spring-config.xml")
public class SpringXmlConfigApplication {

  private static final Logger LOG = LoggerFactory.getLogger(SpringXmlConfigApplication.class);

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SpringXmlConfigApplication.class, args);
//    HelloWorld helloWorldEn = (HelloWorld) ctx.getBean("helloWorldEn");
//    LOG.info(helloWorldEn.greeting());

    HelloWorld helloWorldMy = (HelloWorld) ctx.getBean("helloWorldMy");
    LOG.info(helloWorldMy.greeting());

//    HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorldImpl");
//    LOG.info(helloWorld.greeting());
  }
}
