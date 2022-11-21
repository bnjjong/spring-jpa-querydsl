package com.jjong.springjpaquerydsl.repository;

import com.jjong.springjpaquerydsl.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

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
public interface MemberRepository extends JpaRepository<Member, Long> {

}
