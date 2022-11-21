/*
 * Created By dogfootmaster@gmail.com on 2022
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2022/02/17
 */

package com.jjong.springjpaquerydsl.domain;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

/**
 * create on 2022/02/17. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author Jongsang Han
 * @version 1.0
 * @see
 * @since 1.0
 */
@Entity(name = "members")
@Getter
//@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@TypeDef(name = "json", typeClass = JsonType.class)
public class Member {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private MemberType type;

  @Column(nullable = false)
  private String name;


  /**
   * 나이
   */
  @Column(nullable = false)
  private int age;

  @Embedded
  private Address address;

  @Type(type = "json")
  @Column(columnDefinition = "json")
  private Map<String, Object> jsonData = new HashMap<>();


  public Member(MemberType type, String name, int age,
      Address address, Map<String, Object> jsonData) {
    this.type = type;
    this.name = name;
    this.age = age;
    this.address = address;
    this.jsonData = jsonData;
  }

//  public static MemberBuilder builder(MemberType type, String name, int age,
//      Address address) {
//
//    return new MemberBuilder()
//        .type(type)
//        .name(name)
//        .age(age)
//        .address(address);
//  }
}
