package com.gdu.prj09.dao;

import java.util.List;
import java.util.Map;

import com.gdu.prj09.dto.MemberDto;

public interface MemberDao {
  int insertMember(MemberDto member);

  int UpdateMember(MemberDto member);

  int deleteMember(int memberNo);

  int deleteMembers(List<String> memberNoList);
  
  int getTotalMemberCount();
  
  List<MemberDto> getMemberList(Map<String, Object> map);
  
  MemberDto getMemberByNo(int memberNo);
}
