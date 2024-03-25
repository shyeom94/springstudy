package com.gdu.prj09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.prj09.utils.MyPageUtils;

@Controller
public class MvcController {

  @Autowired
  private MyPageUtils myPageUtils;
  
//  @GetMapping(value={"/", "/main.do"})
//  public String welcome() {
//  System.out.println(myPageUtils.getUploadPath());
//  System.out.println(myPageUtils.getFilesystemName("aaa.ccc.ddd.png"));
//    return "index";
//  }
  
}