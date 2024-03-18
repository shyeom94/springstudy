package com.gdu.prj05.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.gdu.prj05.dao.ContactDao;
import com.gdu.prj05.dto.ContactDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

  private final ContactDao contactDao;
  
  @Override
  public void registerContact(HttpServletRequest request, HttpServletResponse response) {

  }

  @Override
  public void modifyContact(HttpServletRequest request, HttpServletResponse response) {

  }

  @Override
  public void removeContact(HttpServletRequest request, HttpServletResponse response) {

  }

  @Override
  public List<ContactDto> getContactList() {
    
    return null;
  }

  @Override
  public ContactDto getContactByNo(int contactNo) {

    return null;
  }

}
