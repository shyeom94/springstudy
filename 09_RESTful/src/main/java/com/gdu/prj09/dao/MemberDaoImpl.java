package com.gdu.prj09.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.gdu.prj09.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // root-context 와 연결
public class MemberDaoImpl implements MemberDao {

  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public int insertMember(MemberDto member) {
    return 0;
  }

  @Override
  public int UpdateMember(MemberDto member) {
    return 0;
  }

  @Override
  public int deleteMember(int memberNo) {
    return 0;
  }

  @Override
  public int deleteMembers(List<String> memberNoList) {
    return 0;
  }

  @Override
  public int getTotalMemberCount() {
    return 0;
  }

  @Override
  public List<MemberDto> getMemberList(Map<String, Object> map) {
    return null;
  }

  @Override
  public MemberDto getMemberByNo(int memberNo) {
    return null;
  }

}
