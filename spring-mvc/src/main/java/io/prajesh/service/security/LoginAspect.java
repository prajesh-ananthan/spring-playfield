package io.prajesh.service.security;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author Prajesh Ananthan
 *         Created on 2/9/2017.
 */
@Aspect
@Component
@Slf4j
public class LoginAspect {

  // This annotation accepts all data types
  @Pointcut("execution(* org.springframework.security.authentication.AuthenticationProvider.authenticate(..))")
  public void doAuthenticate() {
  }

  @Before("io.prajesh.service.security.LoginAspect.doAuthenticate() && args(authentication)")
  public void logBefore(Authentication authentication) {
    log.info("This is before the Authentication Method authentication " + authentication.isAuthenticated());
  }

  @AfterReturning(value = "io.prajesh.service.security.LoginAspect.doAuthenticate()",
      returning = "authentication")
  public void logAfterAuthenticate(Authentication authentication) {
    log.info("This is after the Authentication Method authentication " + authentication.isAuthenticated());
  }

  @AfterThrowing("io.prajesh.service.security.LoginAspect.doAuthenticate() && args(authentication)")
  public void logAuthenicationException(Authentication authentication) {
    String userDetails = (String) authentication.getPrincipal();
    log.error("Login failed for user: " + userDetails);
  }
}