package com.gdu.prj04.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.prj04.dao.BoardDao;

@Controller
public class MvcController {

  @Inject
  private BoardDao boardDao;

  @GetMapping(value = { "/", "main.do" })
  public String welcome() {
    return "index";
  }
  
  @GetMapping("/exercise1.do") // .jsp로 포워드 한다. 
  public void exercise1() { 
  }
  
  @GetMapping("/exercise2.do") // .jsp로 포워드 한다. 
  public String exercise2() {
    return "exercise2";
  }
  
  @GetMapping("/exercise3.do") // .jsp로 포워드 한다. 
  public String exercise3() {
    return "exercise3";
  }

}
