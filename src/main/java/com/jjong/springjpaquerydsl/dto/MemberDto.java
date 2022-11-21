package com.jjong.springjpaquerydsl.dto;

import com.jjong.springjpaquerydsl.domain.Address;
import com.jjong.springjpaquerydsl.domain.MemberType;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

/**
 * create on 2022/11/16. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 *
 * @author Jongsang Han(henry)
 * @version 1.0
 * @see
 * @since 1.0
 */
@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
public class MemberDto {

  private MemberType type;

  private String name;

  private int age;
  private String city;
  private String street;
  private String zipcode;
  private String jsonData;

}
