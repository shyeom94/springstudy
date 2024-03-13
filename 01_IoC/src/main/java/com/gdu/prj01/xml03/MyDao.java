package com.gdu.prj01.xml03;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyDao {

  private Connection con;
  private MyConnection myConnection;
  // <bean> 태그 안에 IoC Container 에 있음 -> 만들어진 것을 가져온다.

  private Connection getConnection() {
    Connection con = null;
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("com/gdu/prj01/xml03/appCtx.xml");
    myConnection = ctx.getBean("myConnection", MyConnection.class);
    con = myConnection.getConnection();
    ctx.close();
    return con;
  }

  private void close() {
    try {
      if (con != null) {
        con.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
