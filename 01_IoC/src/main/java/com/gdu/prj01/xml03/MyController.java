package com.gdu.prj01.xml03;

import lombok.Data;
import lombok.NoArgsConstructor;

// Controller 를 호출하는 Service
@NoArgsConstructor
@Data
public class MyController {

  private MyService myService;

  public void add() {
    myService.add();
    System.out.println("MyController add() 호출");

  }
}
