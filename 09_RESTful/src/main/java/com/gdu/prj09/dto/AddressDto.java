package com.gdu.prj09.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddressDto {
  private int addressNo; 
  
  private String zonecode; 
  private String address; 
  private String detailAddress; 
  private String extraAddress; 
  
  // private int memberNo; // 회원 번호 -> 
  private MemberDto member; // 회원 번호 -> 
}
