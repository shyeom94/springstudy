package com.gdu.prj07.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.prj07.service.ContactService;

import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/contact")
@RequiredArgsConstructor
@Controller
public class ContactController {

  private final ContactService contactService;

  // private static final Logger log =
  // LoggerFactory.getLogger(ContactController.class); // lombok 작성 가능

  @GetMapping(value = "/list.do")
  public ModelAndView list() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("contactList", contactService.getContactList());
    modelAndView.setViewName("contact/list");
    
    return modelAndView;
  } // list and view 추천하진 않음, 참고만 해라. 소개. 

  @GetMapping(value = "/detail.do")
  public String detail(@RequestParam(value = "contact-no", required = false, defaultValue = "0") int contactNo,
      Model model) {
    model.addAttribute("contact", contactService.getContactByNo(contactNo));
    return "contact/detail";
  } // list and view 
  
  // -------------------------------------------------------------------------

  @GetMapping(value = "/write.do")
  public String write() {
    return "contact/write";
  }

  @PostMapping(value = "/register.do")
  public void register(HttpServletRequest request
                     , HttpServletResponse response
                     , RedirectAttributes redirectAttributes) {
    contactService.registerContact(request, response, redirectAttributes);
  }

  @GetMapping(value = "/remove.do")
  public void remove1(HttpServletRequest request, HttpServletResponse response) {
    contactService.removeContact(request, response);
  }

  @PostMapping(value = "/remove.do")
  public void remove2(HttpServletRequest request, HttpServletResponse response) {
    contactService.removeContact(request, response);
  } 

  @PostMapping(value = "/modify.do")
  public void modify(HttpServletRequest request, HttpServletResponse response) {
    contactService.modifyContact(request, response);
  } 

//  @GetMapping(value = "/tx/test.do")
//  public String txTest() {
//    contactService.txTest();
//    return "redirect:/contact/list.do"; 
//  } 
  
}
