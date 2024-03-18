package com.gdu.prj05.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ContactDto {
  private int contactNo;
  private String namel;
  private String mobile;
  private String email;
  private String address;
  private String createdAt;
}
