package com.gdu.prj07;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;

import java.util.List;

//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.gdu.prj07.dao.ContactDao;
import com.gdu.prj07.dto.ContactDto;

import lombok.extern.slf4j.Slf4j;
                                                                                                                                                                                      
/* 1. JUnit4 를 이용한다. */
//@RunWith(SpringJUnit4ClassRunner.class)

/*
 * 2. ContactDaoImpl 클래스의 bean 생성 방법을 작성한다.
 *  1) <bean>      locations="file:src/main/webapp/WEB-INF/spring/root-context.xml"
 *  2) @Bean       classes=AppConfig.class
 *  3) @Component  locations="file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
 */

/* 메소드의 이름 순으로 테스트를 수행한다. */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

// ContactService 타입의 ContactServiceImpl bean 이 등록된 파일 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

// WebApplicationContext 타입의 bean 을 Spring Container 에 만든다. 
@WebAppConfiguration

@Slf4j
public class ContactMockTest_JUnit4 {// txTest 
  
  @Autowired
  private WebApplicationContext webApplicationContext;
  
  // 테스트를 수행하는 MockMvc 객체 선언 
  private MockMvc mockMvc;
  
  // MockMvc 객체 생성 (테스트 수행 이전에 생성한다.)
  //@Before
  public void setUp() {
    mockMvc = MockMvcBuilders
                  .webAppContextSetup(webApplicationContext)
                .build();
  } 
  
  //@Test
  public void 테스트01_MockMvc생성확인() {
    //assertNotNull(mockMvc);
  } 

  //@Test
  public void 테스트02_삽입() throws Exception {
    
    MvcResult mvcResult = mockMvc
                            .perform(MockMvcRequestBuilders
                                  .post("/contact/register.do")
                                  .param("name", "테스트이름")
                                  .param("mobile", "테스트모바일")
                                  .param("email", "테스트이메일")
                                  .param("address", "테스트주소"))
                            .andReturn();

    // RedirectAttributes 에 flash attribute 를 등록하고 redirect 한 경우
    log.info(mvcResult.getFlashMap().toString()); 
    
    // HttpServletResponse 를 이용해 직접 redirect 코드를 작성한 경우
    log.info(mvcResult.getResponse().getContentAsString());
  
  }
  
  //@Test
  public void 테스트03_상세조회() throws Exception {
    
    MvcResult mvcResult = mockMvc
                             .perform(MockMvcRequestBuilders
                                         .get("/context/detail.do")
                                         .param("contact-no", "1"))
                             .andReturn();
    
    log.info(mvcResult.getModelAndView().getModelMap().toString());
    
  }
  
  /*
  private ContactDao contactDao;
  
  @Autowired
  public void setContactDao(ContactDao contactDao) {
    this.contactDao = contactDao;
  }
  
  @Test
  public void 트랜잭션테스트() {
  }

  @Test
  public void test01_등록() {
    
    ContactDto contact = ContactDto.builder()
                            .name("테스트이름")
                            .mobile("테스트모바일")
                            .email("테스트이메일")
                            .address("테스트주소")
                          .build();
    int insertCount = contactDao.registerContact(contact);
    assertEquals(1, insertCount);
    
  }
  
  @Test
  public void test02_조회() {
    
    int contactNo = 1;
    
    ContactDto contact = contactDao.getContactByNo(contactNo);
    
    assertNotNull(contact);
    
  }
  
  @Test
  public void test03_수정() {
    
    ContactDto contact = ContactDto.builder()
                            .name("[수정]테스트이름")
                            .mobile("[수정]모바일")
                            .email("[수정]테스트이메일")
                            .address("[수정]테스트주소")
                            .contactNo(1)
                          .build();
    
    int updateCount = contactDao.modifyContact(contact);
    
    assertEquals(1, updateCount);
    
  }
  
  @Test
  public void test04_목록() {
    
    List<ContactDto> contactList = contactDao.getContactList();
    
    assertEquals(1, contactList.size());
    
  }
  
  @Test
  public void test05_삭제() {
    
    int contactNo = 1;
    
    int deleteCount = contactDao.removeContact(contactNo);
    
    assertEquals(1, deleteCount);
    
  }
  */
  
}