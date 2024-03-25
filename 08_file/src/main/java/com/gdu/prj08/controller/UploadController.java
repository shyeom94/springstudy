package com.gdu.prj08.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.prj08.service.UploadService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 의존성 주입 
@Controller
public class UploadController {
  
  private final UploadService uploadService;
  
  @PostMapping("/upload1.do")
  public String upload1(MultipartHttpServletRequest multipartHttpServletRequest
                      , RedirectAttributes redirectAttributes) { 
    
    int insertCount = uploadService.upload1(multipartHttpServletRequest);
    redirectAttributes.addFlashAttribute("insertCount", insertCount);
    return "redirect:/main.do";
  }
  
  @ResponseBody
  @PostMapping(value="/upload2.do", produces="application/json")
  public Map<String, Object> upload2(MultipartHttpServletRequest multipartRequest){
    return uploadService.upload2(multipartRequest);
  }
  
  // 이런 식으로도 가능 
  /*
   * @PostMapping(value = "/upload2.do", produces = "application/json") public
   * ResponseEntity<Map<String, Object>> upload2(MultipartHttpServletRequest
   * multipartRequest){ return new ResponseEntity(Map.of("success", 1),
   * HttpStatus.OK); }
   */

}
