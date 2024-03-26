package com.gdu.prj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.gdu.prj09.dto.MemberDto;

public interface MemberService {
//Service 는 Dao 를 1 : 1 로 호출하지 않는다. 하나의 Service 는 여러개의 Dao 를 호출한다. 

//ResponseEntity : SPA (Single Page Application) 타입으로 반환할 때 사용하는 Wrapper
  ResponseEntity<Map<String, Object>> getMembers(int page, int display);

  ResponseEntity<Map<String, Object>> getMemberByNo(int memberNo);

  ResponseEntity<Map<String, Object>> registerMember(Map<String, Object> map, HttpServletResponse response);

  ResponseEntity<Map<String, Object>> modifyMember(MemberDto member);

  ResponseEntity<Map<String, Object>> removeMember(int memberNo);

  ResponseEntity<Map<String, Object>> removeMembers(String memberNoList);
  
  // HttpServletRequest
  // @RequestParam ---------- @PathVariable
  // MyPageUtils
  
}