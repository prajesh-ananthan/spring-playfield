package io.prajesh.config;

import io.prajesh.service.UserService;
import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Prajesh Ananthan
 *         Created on 20/8/2017.
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  @Qualifier("daoAuthenticationProvider")
  private AuthenticationProvider authenticationProvider;

  @Bean
  public PasswordEncoder passwordEncoder(StrongPasswordEncryptor strongPasswordEncryptor) {
    PasswordEncoder passwordEncoder = new PasswordEncoder();
    passwordEncoder.setPasswordEncryptor(strongPasswordEncryptor);
    return passwordEncoder;
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder,
                                                             UserDetailsService userDetailsService) {

    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    return daoAuthenticationProvider;
  }

  @Autowired
  public void setAuthManager(AuthenticationManagerBuilder authenticationManagerBuilder) {
    authenticationManagerBuilder.authenticationProvider(authenticationProvider);
  }

  @Override
  // Securing URLs with Spring Security
  // Prevents user from accessing unauthorized page to login page
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().ignoringAntMatchers("/console").disable()
        .headers().frameOptions().sameOrigin()
        .and().authorizeRequests().antMatchers("/**/favicon.ico").permitAll()
        .and().authorizeRequests().antMatchers("/product/**").permitAll()
        .and().authorizeRequests().antMatchers("/webjars/**").permitAll()
        .and().authorizeRequests().antMatchers("/static/css").permitAll()
        .and().authorizeRequests().antMatchers("/js").permitAll()
        .and().formLogin().loginPage("/login").permitAll()
        .and().authorizeRequests().antMatchers("/customer/**").authenticated()
        .and().authorizeRequests().antMatchers("/user/**").hasAuthority(UserService.ADMIN)
        .and().exceptionHandling().accessDeniedPage("/access_denied");
  }
}
