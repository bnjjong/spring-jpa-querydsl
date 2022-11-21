package com.jjong.springjpaquerydsl.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjong.springjpaquerydsl.domain.Address;
import com.jjong.springjpaquerydsl.domain.Member;
import com.jjong.springjpaquerydsl.dto.MemberDto;
import com.jjong.springjpaquerydsl.repository.MemberRepository;
import com.jjong.springjpaquerydsl.repository.MemberRepositoryWithQueryDsl;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
@Service
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository repository;
  private final MemberRepositoryWithQueryDsl repositoryWithQueryDsl;




  public void save(MemberDto dto) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    Member member = new Member(dto.getType(),
        dto.getName(),
        dto.getAge(),
        new Address(dto.getCity(),
            dto.getStreet(),
            dto.getZipcode()),
        objectMapper.readValue(dto.getJsonData(), Map.class));

    repository.save(member);
  }

  public List<Member> findByJson(String name, String value) {
    return repositoryWithQueryDsl.findByJson(name, value);
  }
}
