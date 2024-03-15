package com.gdu.prj04.dao; 
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.prj04.dto.BoardDto;

import lombok.AllArgsConstructor;
 
@Repository // 컴포넌트로 만든다 -> BoardDaoImpl 도 Spring Container 에 저장된다. 
@AllArgsConstructor // * * * 최종적인 모습 * * * 
public class BoardDaoImpl implements BoardDao {
 
  // 필드 생성 
  
//  // @Autowired // 생략 가능하다.
//  public BoardDaoImpl(BoardDto board1, BoardDto board2, BoardDto board3) {
//    super();
//    this.board1 = board1;
//    this.board2 = board2;
//    this.board3 = board3;
//  } // @AllArgsConstructor 
 
  private BoardDto board1;
  private BoardDto board2;
  private BoardDto board3;
  
  // Spring Container 에 있다.
  
  // 메소드의 이름과 Bean 의 이름이 일치해야 함.

  // @Autowired 사용법 : 
  // 1. 필드에 Bean 을 주입하는 필드주입 방식
  //@Autowired
  //private BoardDto board1;
  //@Autowired
  //private BoardDto board2;
  //@Autowired
  //private BoardDto board3;
  
  // 2. 생성자 ------------------------------------> 이 방식으로 사용한다.
  // 생성자에 의해서 

  // 3. setter 
  //  @Autowired
  //  private void setBean(BoardDto board1, BoardDto board2, BoardDto board3,) {
  //    this.board1 = board1;
  //    this.board2 = board2;
  //    this.board3 = board3;
  //  }
  //  // 메소드의 매개변수를 자동 주입 대상으로 본다. -> 최종적으로는 필드에 주입된다.   
  
  
  @Override
  public List<BoardDto> getBoardList() {

    return Arrays.asList(board1, board2, board3);
  }

  @Override
  public BoardDto getBoardByNo(int boardNo) {
    BoardDto board = null;
    switch(boardNo) {
    case 1 : board = board1; break;
    case 2 : board = board2; break;
    case 3 : board = board3; break;
    }
    return board;
  }

}
