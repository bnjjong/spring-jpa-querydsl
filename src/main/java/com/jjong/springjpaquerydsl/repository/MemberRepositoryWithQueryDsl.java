/*
 * Created By dogfootmaster@gmail.com on 2022
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2022/02/17
 */

package com.jjong.springjpaquerydsl.repository;

import com.jjong.springjpaquerydsl.domain.Member;
import com.jjong.springjpaquerydsl.domain.MemberType;
import com.jjong.springjpaquerydsl.domain.QMember;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
@Repository
@RequiredArgsConstructor
public class MemberRepositoryWithQueryDsl {
  private final EntityManager em;


  public List<Member> findByType(MemberType type) {
    JPAQuery<Member> query = new JPAQuery<>(em);
    QMember qMember = new QMember("m"); // 생성 된 Alias m
    List<Member> members = query.from(qMember)
        .where(qMember.type.eq(type))
        .orderBy(qMember.name.asc())
        .fetch()
        .stream().toList();

    return members;
  }

  public List<Member> findByTypeAndGtAge(MemberType type, int age) {
    JPAQuery<Member> query = new JPAQuery<>(em);
    QMember qMember = QMember.member;

    List<Member> members = query.from(qMember)
//        .where(qMember.type.eq(type).and(qMember.age.gt(age)))
        .where(qMember.type.eq(type), qMember.age.gt(age)) // 위에꺼와 동일 함.
        .orderBy(qMember.name.asc())
        .fetch()
        .stream().toList();

    return members;
  }

  public List<Member> findByJson(String key, String value) {
    JPAQuery<Member> query = new JPAQuery<>(em);
    QMember qMember = QMember.member;

    return query.from(qMember)
        .where(Expressions.stringTemplate("JSON_EXTRACT(json_data, '$."+key+"')").eq(value))
        .fetch();
  }

}
