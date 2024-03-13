package com.gdu.prj01.anno01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // IoC Container 에 bean 을 등록하는 클래스
public class AppConfig { // <bean> 을 만드는 Configuration

  /*
   * 반환타입 : bean 의 타입, <bean class=""> 메소드명 : bean 의 이름, <bean id="">
   */
  @Bean
  public Calculator calculator() { // 메소드 이름을 bean 의 id 로 준다.

    return new Calculator();
  }

//  @Bean(name = "calculator") // 이름 지정, 잘 안쓴다.
//  public Calculator asdfghjkl() {
//    return new Calculator();
//  }

  @Bean
  public Computer computer1() {
    Computer computer1 = new Computer();
    computer1.setModel("gram");
    computer1.setPrice(200);
    computer1.setCalculator(calculator());
    return computer1;
  }

  @Bean
  public Computer computer2() {
    return new Computer("macbook", 300, calculator());
  }

}
