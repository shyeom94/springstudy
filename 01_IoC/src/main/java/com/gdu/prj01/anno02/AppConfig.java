package com.gdu.prj01.anno02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Student student() {
    Student student = new Student();
    student.setScores(Arrays.asList(90, 91, 92));
    student.setContacts(new HashSet<String>(Arrays.asList("02-3425-2353", "010-3245-5464")));
    student.setFriends(Map.of("동네친구", "길동", "운동친구", "박동"));
    return student;
  }

}
