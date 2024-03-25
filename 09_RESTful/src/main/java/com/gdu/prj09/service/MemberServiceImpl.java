package com.gdu.prj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gdu.prj09.dao.MemberDao;
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
  public ResponseEntity<MemberDto> getMemberByNo() {
    return null;
  }

  @Override
  public ResponseEntity<Map<String, Object>> registerMember(MemberDto member, HttpServletResponse response) {

    int insertCount = memberDao.insertMember(member);

    return new ResponseEntity<Map<String, Object>>( 
        Map.of("insertCount", insertCount), 
        HttpStatus.OK); 
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
