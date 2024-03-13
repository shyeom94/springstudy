package com.gdu.prj01.anno03;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyDao {

  private Connection con;
  private MyConnection myConnection; // setter() 로 전달한다.
  // <bean> 태그 안에 IoC Container 에 있음 -> 만들어진 것을 가져온다.
  
  // <bean> 의 <property name="myConnection" ref="myConnection" /> 때문에 필요 없어짐.
//  private Connection getConnection() {
//    Connection con = null;
//    AbstractApplicationContext ctx = new GenericXmlApplicationContext("com/gdu/prj01/xml03/appCtx.xml");
//    myConnection = ctx.getBean("myConnection", MyConnection.class);
//    con = myConnection.getConnection();
//    ctx.close();
//    return con;
//  }

  private void close() {
    try {
      if (con != null) {
        con.close();
        System.out.println(myConnection.getUser() + " 접속해제되었습니다.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void add() {
    // con = getConnection();
    con = myConnection.getConnection();

    System.out.println("MyDao add() 호출");

    close();
  }
}
