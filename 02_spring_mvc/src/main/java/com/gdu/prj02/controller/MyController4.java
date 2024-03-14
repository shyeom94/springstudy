package com.gdu.prj02.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.prj02.dto.BlogDto;
// import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController4 {

  // @RequestMapping(value = "/blog/list.do", method = RequestMethod.GET) // method = RequestMethod.GET 생략 가능, 기본 GET 방식
  // @RequestMapping(value = "/blog/list.do") // value 만 남아있을 경우, value 생략 가능
  @RequestMapping("/blog/list.do") // 생략 후 최종 결과물 
  public String list(Model model) {
    
    // DB 에서 select 한 결과 리스트 
    List<BlogDto> blogList = Arrays.asList(
        new BlogDto(1, "제목1"),        
        new BlogDto(2, "제목2"),        
        new BlogDto(3, "제목3")        
        );
    
    // request.setAttribute("blogList", blogList); 
    // Model 에 저장한 값은 forward 할 때 전달된다. 
    model.addAttribute("blogList", blogList);
            
    // 기본 이동 방식은 forward 방식이다. -> forward 는 데이터 전달이 가능하다.
    return "/blog/list"; // 반환값이 의미하는 것. 경로 WEB-INF - views - blog - list.jsp 를 실행한다. 
  }
  
  @RequestMapping("/blog/detail.do") // RequestMapping 은 기본 GET 방식 
  public String detail(@RequestParam(value="blogNo" // 값은 "blogNo"
                                    , required=false // 필수 조건 아님 
                                    , defaultValue="0") // 기본값 0
                                      int blogNo, Model model) { // forward 를 위해 매개변수로 Model 선언 
    
    // DB 에서 가져온 데이터
    BlogDto blog = BlogDto.builder()
                        .blogNo(blogNo)
                        .title("제목 " + blogNo)
                        .build();
    
    // JSP 로 전달할 데이터
    model.addAttribute("blog", blog);

    // blog/detail.jsp 로 forward
    return "blog/detail";
    }

  // @RequestMapping(value = "/blog/add.do", method=RequestMethod.POST) 
  public String add(BlogDto blog) { // 커맨드 객체의 Model 저장 방식 : 클래스 타입을 camelCase 로 변경해서 저장한다.
             // BlogDto -> blogDto 로 변경해서 저장    
    
    // blog/addResult.jsp 로 forward 
    return "blog/addResult";
  }

  @RequestMapping(value = "/blog/add.do", method=RequestMethod.POST) 
  public String add2(@ModelAttribute("blog") BlogDto blog) {  // @ModelAttribute : 커맨드 객체가 Model 에 저장되는 이름을 지정할 때 사용한다.
    
    return "blog/addResult";
  }
  
  // 보낼 때 request, 받을 때 Model
  
}
