package com.gdu.prj09.utils;

public class MyPageUtils {

  private int total; // 전체 게시글 갯수
  private int display; // 한번에 보여질 게시글 갯수
  private int page; // 현재 페이지
  // Map 만든다 
  
  private int begin;
  private int end;

  private int pagePerBlock = 10;
  private int totalPage;
  private int beginPage;
  private int endPage;

  public void setPaging(int total, int display, int page) {

    this.total = total;
    this.display = display;
    this.page = page;

    begin = (page - 1) * display + 1;
    end = begin + display - 1;

    totalPage = (int) Math.ceil((double) total / display); // ceil 
    beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
    endPage = Math.min(totalPage, beginPage + pagePerBlock + 1);
  }
}
