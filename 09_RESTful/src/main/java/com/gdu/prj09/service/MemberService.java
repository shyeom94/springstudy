package com.gdu.prj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.gdu.prj09.dto.MemberDto;

public interface MemberService {
// Service 는 Dao 를 1 : 1 로 호출하지 않는다. 하나의 Service 는 여러개의 Dao 를 호출한다. 

  // ResponseEntity : SPA (Single Page Application) 타입으로 반환할 때 사용하는 Wrapper

  // 목록
  ResponseEntity<Map<String, Object>> getMembers(int page, int display);

  // 상세
  ResponseEntity<MemberDto> getMemberByNo();

  // 삽입
  ResponseEntity<Map<String, Object>> registerMember(MemberDto member, HttpServletResponse response);// jackson Library

  // 수정
  ResponseEntity<Map<String, Object>> modifyMember(MemberDto member);

  // 삭제(1)
  ResponseEntity<Map<String, Object>> removeMember(int memberNo); // RESTful 하게 작성

  // 삭제(2)
  ResponseEntity<Map<String, Object>> removeMembers(String memberNoList); // 여러개의 memberNo 받아옴  

  // HttpServletRequest
  // @RequestParam ---------- @PathVariable
  // MyPageUtils

}
