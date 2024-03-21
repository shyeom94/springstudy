package com.gdu.prj07.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.prj07.service.ContactService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component 
@RequiredArgsConstructor
public class ContactSchedular {
  
  private final ContactService contactService; 
  
  @Scheduled(cron = "0 42 11 * * *") // 11시 40분마다 로그찍기 
  public void execute() {
    log.info("{}개", contactService.getContactList().size());
  }
  
  /*
   * Cron 표현식
   * 
   * 1. 형식 
   *    초  분  시  일  월  요일  
   *    
   * 2. 상세 형식
   *    1) 초   : 0 ~ 59 
   *    2) 분   : 0 ~ 59 
   *    3) 시   : 0 ~ 23
   *    4) 일   : 1 ~ 31
   *    5) 월   : 0 ~ 11 (JAN FEB MAR APR MAY JUN JUL AUG SEP OCT NOV DEC)
   *    6) 요일 : 1 ~ 7  (MON TUE WED THR FRI SAT SUN)
   *    
   * 3. 키워드
   *    1) ? : 설정 없음 (요일)
   *    2) * : 모든 (초 분 시 일 월)
   *    3) - : 범위 (ex 0-30)
   *    4) / : 주기 
   * 
   * 4. 예시
   *    1) 0 0 * * * *      : 매일 모든 시간마다 
   *    2) 0 0 3 * * *      : 매일 3시마다 
   *    3) 0 0 3-5 * * *    : 매일 3,4,5시마다 
   *    4) 0 0 3,5 * * *    : 매일 3,5시마다 
   *    5) 0 0/30 3-5 * * * : 매일 3,5시마다 
   *    
   *    6) 0 0/30 3-5 * * * : 매일 3,5시마다 
   *    
   */
  
}
