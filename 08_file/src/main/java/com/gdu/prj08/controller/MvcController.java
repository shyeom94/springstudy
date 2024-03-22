package com.gdu.prj08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.prj08.utils.MyFileUtils;

@Controller
public class MvcController {

  @Autowired
  private MyFileUtils myFileUtils;
  
  @GetMapping(value={"/", "/main.do"})
  public String welcome() {
  System.out.println(myFileUtils.getUploadPath());
  System.out.println(myFileUtils.getFilesystemName("aaa.ccc.ddd.png"));
    return "index";
  }

}