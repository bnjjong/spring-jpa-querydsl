package com.jjong.springjpaquerydsl.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jjong.springjpaquerydsl.application.MemberService;
import com.jjong.springjpaquerydsl.domain.Member;
import com.jjong.springjpaquerydsl.dto.MemberDto;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
public class MemberApi {

  private final MemberService memberService;

  @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
  public String save(@RequestBody MemberDto dto) throws JsonProcessingException {
    memberService.save(dto);
    return "success";
  }

  @GetMapping(value = "/{name}/{value}", produces = APPLICATION_JSON_VALUE)
  public List<Member> findByJson(@PathVariable(value = "name") String name,
      @PathVariable(value = "value") String value) {
    return memberService.findByJson(name, value);
  }
}
