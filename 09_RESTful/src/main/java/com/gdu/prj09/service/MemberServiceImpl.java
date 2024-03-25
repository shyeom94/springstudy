package com.gdu.prj09.service;

import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gdu.prj09.dao.MemberDao;
import com.gdu.prj09.dto.AddressDto;
import com.gdu.prj09.dto.MemberDto;
import com.gdu.prj09.utils.MyPageUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 생성자 -> Spring 컨테이너(IoC Container) 로부터 Bean 을 찾아서 집어넣어주는 역할
public class MemberServiceImpl implements MemberService {

  // Dao
  private final MemberDao memberDao;

  // MypageUtils
  private final MyPageUtils myPageUtils;

  @Override
  public ResponseEntity<Map<String, Object>> getMembers(int page, int display) {
    return null;
  }

  @Override
  public ResponseEntity<MemberDto> getMemberByNo(int memberNo) {
    return null;
  }

  @Override
  public ResponseEntity<Map<String, Object>> registerMember(Map<String, Object> map, HttpServletResponse response) {

    ResponseEntity<Map<String, Object>> result = null;
    
    try {

      MemberDto member = MemberDto.builder()
                              .email((String) map.get("email"))
                              .name((String) map.get("name"))
                              .gender((String) map.get("gender"))
                            .build();

      int insertCount = memberDao.insertMember(member);
      
      AddressDto address = AddressDto.builder()
                                .zonecode((String) map.get("zonecode"))
                                .address((String) map.get("address"))
                                .detailAddress((String) map.get("detailAddress"))
                                .extraAddress((String) map.get("extraAddress"))
                              .build(); 
      
      insertCount += memberDao.insertAddress(address);
      
      result = new ResponseEntity<Map<String, Object>>(
                      Map.of("insertCount", insertCount), 
                      HttpStatus.OK);

    } catch (DuplicateKeyException e) { // catch(Exception e) { 이름 확인 : e.getClass().getName()} 찍어보기 
      
      try {
        
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("이미 가입된 이메일입니다."); // jqXHR 객체의 responseText 속성으로 확인
        out.flush();
        out.close();
        
      } catch (Exception e2) {
      e2.printStackTrace();
      }
      
    }

    return result;
  }

  @Override
  public ResponseEntity<Map<String, Object>> modifyMember(MemberDto member) {
    return null;
  }

  @Override
  public ResponseEntity<Map<String, Object>> removeMember(int memberNo) {
    return null;
  }

  @Override
  public ResponseEntity<Map<String, Object>> removeMembers(String memberNoList) {
    return null;
  }

}
