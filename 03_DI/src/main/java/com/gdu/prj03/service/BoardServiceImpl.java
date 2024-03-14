package com.gdu.prj03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.prj03.dao.BoardDao;
import com.gdu.prj03.dto.BoardDto;

//컴포넌트         @controller   @service    @Repository     -> Bean 이 3개
//           view - controller -  service  -  dao 

@Service
public class BoardServiceImpl implements BoardService { // Service 가 필요로 하는것은 Dao

  @Autowired
  private BoardDao boardDao;

  @Override
  public List<BoardDto> getBoardList() {
    return boardDao.getBoardList();
  }

  @Override
  public BoardDto getBoardByNo(int boardNo) {
    return boardDao.getBoardByNo(boardNo);
  }
}
