package com.gdu.prj04.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.prj04.dao.BoardDao;
import com.gdu.prj04.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // final 필드 주입에 사용.
public class BoardServiceImpl implements BoardService {

  private final BoardDao boardDao; // 데이터 변조를 막기 위해 final 사용

  // final 필드의 주입은 생성자 중 @RequiredArgsConstructor 으로 사용한다.

  @Override
  public List<BoardDto> getBoardList() {
    return boardDao.getBoardList();
  }

  @Override
  public BoardDto getBoardByNo(int boardNo) {
    return boardDao.getBoardByNo(boardNo);
  }

}
