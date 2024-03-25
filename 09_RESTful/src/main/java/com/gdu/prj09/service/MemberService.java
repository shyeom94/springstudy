package com.gdu.prj09.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface MemberService {
// Service 는 Dao 를 1 : 1 로 호출하지 않는다.
// 하나의 Service 는 여러개의 Dao 를 호출한다.
  
  // 목록 상세 삽입 수정 삭제(1) 삭제(2) 
  
//ResponseEntity : SPA (Single Page Application) 타입으로 반환할 때 사용하는 Wrapper
  public ResponseEntity<Map<String, Object>> getMembers() 
//    HttpServletRequest 
//    @RequestParam ---------- @PAthVariable 
//    MyPageUtils 
}
