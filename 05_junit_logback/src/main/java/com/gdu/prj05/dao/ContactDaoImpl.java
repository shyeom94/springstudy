package com.gdu.prj05.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.gdu.prj05.dto.ContactDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 필드 처리를 위한 생성자 주입 ! ! ! ! ! 중요 ! ! ! ! ! 
@Repository // Dao 용 컴포넌트 / Spring Container Bean 으로 만든다. 
@ComponentScan // 컴포넌트 찾는 패키지 경로 명시하는 -> 적지 않는다. Dispacher contact -> servlet-context 여기에 적혀있다! 
public class ContactDaoImpl implements ContactDao {

  private final SqlSessionTemplate sqlSessionTemplate;
  
  public final static String NS = "com.gdu.prj05.mybatis.mapper.contact_t.";

  @Override
  public int registerContact(ContactDto contact) {
    int insertCount = sqlSessionTemplate.insert(NS + "registerContact", contact); // mapper.id 
    return insertCount; 
  }

  @Override
  public int modifyContact(ContactDto contact) {
    int updateCount = sqlSessionTemplate.update(NS + "modifyContact", contact); 
    return updateCount; 
  }

  @Override
  public int removeContact(int contactNo) {
    int deletecount = sqlSessionTemplate.delete(NS + "removeContact", contactNo); 
    return deletecount;
  }

  @Override
  public List<ContactDto> getContactList() {
    List<ContactDto> contactList = sqlSessionTemplate.selectList(NS + "getContactList");
    return contactList;
  }

  @Override
  public ContactDto getContactByNo(int contactNo) {
    ContactDto contact = sqlSessionTemplate.selectOne(NS + "getContactByNo", contactNo);
    return contact;
  }

}
