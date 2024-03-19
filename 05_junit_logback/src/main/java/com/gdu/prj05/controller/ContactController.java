package com.gdu.prj05.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.prj05.service.ContactService;

import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/contact")
@RequiredArgsConstructor
@Controller

public class ContactController {

  private final ContactService contactService;

  @GetMapping(value = "/list.do") // View Resolver 에 의해 완성되는 모습 
  public String list(Model model) {
    model.addAttribute("contactList", contactService.getContactList());
    return "contact/list";
  }
  
  @GetMapping(value = "/detail.do") // 
  public String detail(@RequestParam(value="contact-no", required = false, defaultValue = "0") int contactNo
                      ,Model model) {
    model.addAttribute("contact", contactService.getContactByNo(contactNo));
    return "contact/detail";
  }
  
  @GetMapping(value = "/write.do") // 
  public String write() {
    return "contact/write";
  }
  
  @PostMapping(value = "/register.do")
  public void register(HttpServletRequest request, HttpServletResponse response) {
    contactService.registerContact(request, response); // 컨트롤러가 할 일 
  }
  
  @GetMapping(value = "/remove.do") // 
  public void remove1(HttpServletRequest request, HttpServletResponse response) {
    contactService.removeContact(request, response);  
  }
  
  @PostMapping(value = "/remove.do") // 
  public void remove2(HttpServletRequest request, HttpServletResponse response) {
    contactService.removeContact(request, response);  
  }
 
  @PostMapping(value = "/modify.do")
  public void modify(HttpServletRequest request, HttpServletResponse response) {
    contactService.modifyContact(request, response); // 컨트롤러가 할 일 
  }

}
