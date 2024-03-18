package com.gdu.prj05; 

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.prj05.dao.ContactDao;
import com.gdu.prj05.dto.ContactDto;

import lombok.RequiredArgsConstructor; 

/* 1. Junit4 를 이용한다. */ 
@RunWith(SpringJUnit4ClassRunner.class) 

 /* 
  * 2. ContactDaoImpl 클래스의 bean 생성 방법을 작성한다.
  *   1) <bean>     locations="file:src/main/webapp/WEB-INF/spring/root-context.xml"
  *   2) @Bean      classes=AppConfig.class
  *   3) @Component locations="file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
  */

@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml") 

@RequiredArgsConstructor // 생성자 주입을 위해 
public class ContactUnitTest {
  
  private final ContactDao contactDao;
  
  @Test
  public void 등록테스트() {
    ContactDto contact = ContactDto.builder()
                            .namel("테스트이름")
                            .mobile("테스트모바일")
                            .email("테스트이메일")
                            .address("테스트주소")
                         .build();
    
    int insertCount = contactDao.registerContact(contact);
    assertEquals(1, insertCount);
  }

}
