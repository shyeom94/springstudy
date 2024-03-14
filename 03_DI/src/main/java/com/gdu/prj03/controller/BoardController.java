package com.gdu.prj03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.prj03.service.BoardService;

//컴포넌트         @controller   @service    @Repository     -> Bean 이 3개
//          view - controller -  service  -  dao 

@Controller // Controller 에서 사용하는 @Component
public class BoardController {

  /******************************* DI ***************************************/
  /*
   * Dependency Injection
   * 1. 의존 주입
   * 2. Spring Container 에 저장된 bean 을 특정 객체에 넣어 주는 것을 의미한다. 
   * 3. 방법
   *    1) 필드 주입 
   *    2) 생성자 주입 
   *    3) setter 주입 
   * 4. 사용 가능한 annotation
   *    1) @Inject               - Java
   *    2) @Resource, @Qualifier - 추가로 쓸 것이 있다.  
   *    3) @Autowired   =>   대부분 이것을 사용한다. (거의 전부) 
   */
 
  // 1. 필드 주입
  @Autowired 
  // private BoardService boardService; 
  
  // 2. 생성자 주입 
  //    1) 생성자의 매개변수로 주입된다. 
  //    2) @Autowired 를 생략할 수 있다. 
//  private BoardService boardService; 
//  
//  // @Autowired // (생략 가능)
//  public BoardController(BoardService boardService) { // 생성자의 매개변수로 자동 주입된다. 
//    super(); 
//    this.boardService = boardService; // 본문에서 필드로 전달된다. 
//  }
  
  // 3. setter 주입 

  
  
  
  
  
  
  
  
  
  
  
  @GetMapping("/board/list.do")
  public String list(Model model) {
    model.addAttribute("boardList", boardService.getBoardList());
    return "board/list";
  }
  
  @GetMapping("/board/detail.do")
  public String detail(int boardNo, Model model) {
    
    model.addAttribute("board", boardService.getBoardByNo(boardNo));
    return "board/detail";    
  }

}
