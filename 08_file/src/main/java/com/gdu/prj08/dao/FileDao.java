package com.gdu.prj08.dao;

import java.util.List;

import com.gdu.prj08.dto.HistoryDto;

public class FileDao {
  
  int registerContact(ContactDto contact);

  int modifyContact(ContactDto contact);

  int removeContact(int contactNo);

}
  
}
