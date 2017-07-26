package io.prajesh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMvcApplication {
  private static ApplicationContext ctx;
  private Logger log = LoggerFactory.getLogger(SpringMvcApplication.class);

  public static void main(String[] args) {
    ctx = SpringApplication.run(SpringMvcApplication.class, args);
  }

  private void viewLoadedBeans() {
    log.info("Beans*******");
    log.info("Total beans: " + ctx.getBeanDefinitionCount());
    for (String bean : ctx.getBeanDefinitionNames()) {
      log.info("Bean -> " + bean);
    }
  }
}
