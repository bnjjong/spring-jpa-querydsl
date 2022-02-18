/*
 * Created By dogfootmaster@gmail.com on 2022
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2022/02/17
 */

package com.jjong.springjpaquerydsl.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.jjong.springjpaquerydsl.domain.Member;
import com.jjong.springjpaquerydsl.domain.MemberType;
import com.jjong.springjpaquerydsl.test.RepositoryTest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

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
@Import(MemberRepositoryWithQueryDsl.class)
@Sql(scripts = {"classpath:init/member_insert.sql"})
@Rollback(value = false)
@Slf4j
class MemberRepositoryWithQueryDslTest extends RepositoryTest {
  @Autowired
  private MemberRepositoryWithQueryDsl memberRepositoryWithQueryDsl;

  @Test
  public void Given_Type_When_Find_Then_FindMembers() throws Exception {
    // given
    MemberType type = MemberType.NORMAL;

    // when
    List<Member> members = memberRepositoryWithQueryDsl.findByType(type);


    // then
    members.forEach(member -> {
      log.info("member : {}", member);
      // type check
      assertThat(member.getType()).isEqualTo(MemberType.NORMAL);
    });
    assertThat(members.size()).isEqualTo(6);
  }

  @Test
  @DisplayName("do test")
  public void Given_TypeAndAge_When_Find_Then_FindMembers() throws Exception {
    // given
    MemberType type = MemberType.NORMAL;
    int age = 20;

    // when
    List<Member> members = memberRepositoryWithQueryDsl.findByTypeAndGtAge(type, age);

    // then
    members.forEach(member -> {
      log.info("member : {}", member);
      // type check
      assertThat(member.getType()).isEqualTo(MemberType.NORMAL);
      assertThat(member.getAge()).isGreaterThan(age);

    });
    assertThat(members.size()).isEqualTo(3);
  }
}