package io.prajesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ANAN011 on 20/7/2017.
 *
 * @author Prajesh Ananthan, arvato Systems Malaysia Sdn Bhd
 */
@Controller
public class IndexController {

  @RequestMapping("/")
  public String home() {
    return "index";
  }
}
