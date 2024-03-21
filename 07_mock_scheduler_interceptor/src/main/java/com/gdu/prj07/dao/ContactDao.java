package com.gdu.prj07.dao;

import java.util.List;

import com.gdu.prj07.dto.ContactDto;
// logic  : view   -   controller   -   service   -   dao   -   db
// aspect :           log           tx (transaction)
// before 동작 전
//                           after 동작 후
// around 동작 전후          around 동작 전후
public interface ContactDao {
  int registerContact(ContactDto contact);

  int modifyContact(ContactDto contact);

  int removeContact(int contactNo);

  List<ContactDto> getContactList();

  ContactDto getContactByNo(int contactNo);
}
/*
 * 1. AOP (Aspect Oriented Programming) 용어 
 *    1) JoinPoint : Aspect 를 적용시킬 수 있는 메소드 전체 
 *    2) PointCut  : Aspect 를 적용시킨 메소드를 의미
 *    3) Advice    : Aspect 동작 자체 // log 찍기, Transaction 
 *  
 *  2. AOP 용어 예시
 *    1) JoinPoint : ServiceImpl 의 모든 메소드   (삽입, 수정, 삭제, 목록, 상세) 
 *    2) PointCut  : Transaction 이 필요한 메소드 (삽입, 수정, 삭제) 
 *    3) Advice    : Transaction 자체 
 *  
 *  3. Advice 동작 시점 3가지
 *    1) @Before : PointCut 동작 이전 
 *    2) @After  : PointCut 동작 이후 
 *    3) @Around : PointCut 동작 이전/이후 
 *  
 *  4. Adivce 동작 순서
 *    @Around -> @Before -> PointCut -> @Around -> @After 
 *    
 *  5. PointCut 을 결정하는 표현식
 *    1) 형식
 *      execution (반환타입 패키지.클래스.메소드(매개변수)) => 메소드 적는거임! 
 *    2) 상세 형식
 *       (1) 반환타입
 *          - *     : 모든 반환타입 
 *          - void  : void 반환타입 
 *          - !void : void 가 아닌 반환타입 
 *       (2) 매개변수
 *          - *     : 1개의 모든 매개변수 
 *          - ..    : 모든 매개변수 
 *      
 */