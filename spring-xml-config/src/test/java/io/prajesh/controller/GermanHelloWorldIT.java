package io.prajesh.controller;

import io.prajesh.service.HelloWorldService;
import io.prajesh.service.impl.HelloWorldServiceES;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by ANAN011 on 20/7/2017.
 *
 * @author Prajesh Ananthan, arvato Systems Malaysia Sdn Bhd
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/greeting-test-config.xml"})
public class GermanHelloWorldIT {

  @Autowired
  HelloWorldService helloWorldServiceEs;

  @Test
  public void testHelloWorldFromProfile() throws Exception {
    assertThat(helloWorldServiceEs, instanceOf(HelloWorldServiceES.class));
    assertEquals("Hola Mundo!", helloWorldServiceEs.getMessage());
  }
}