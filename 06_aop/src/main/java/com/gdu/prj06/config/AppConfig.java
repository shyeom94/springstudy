package com.gdu.prj06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.gdu.prj06.aspect.MyAfterAspect;
import com.gdu.prj06.aspect.MyAroundAspect;
import com.gdu.prj06.aspect.MyBeforeAspect;

// Bean 을 만드는 클래스. Configuration 

@EnableAspectJAutoProxy
@Configuration
public class AppConfig { // @Component 를 대체하는 코드

  @Bean
  public MyAroundAspect myAroundAspect() {
    return new MyAroundAspect();
  }

  @Bean
  public MyBeforeAspect myBeforeAspect() {
    return new MyBeforeAspect();
  }

  @Bean
  public MyAfterAspect myAfterAspect() {
    return new MyAfterAspect();
  }

}
