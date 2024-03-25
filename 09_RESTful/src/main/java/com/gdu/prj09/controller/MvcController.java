package com.gdu.prj09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.prj09.utils.MyPageUtils;

@Controller
public class MvcController {

  @Autowired
  private MyPageUtils myFileUtils;
  
  @GetMapping(value={"/", "/main.do"})
  public String welcome() {
  System.out.println(myFileUtils.getUploadPath());
  System.out.println(myFileUtils.getFilesystemName("aaa.ccc.ddd.png"));
    return "index";
  }
  
}