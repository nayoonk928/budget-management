package com.example.budget.controller.common;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.example.budget.dto.req.MemberLoginReqDto;
import com.example.budget.entity.Member;
import com.example.budget.repository.CategoryRepository;
import com.example.budget.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class ControllerTest {

  @Autowired
  protected MockMvc mockMvc;

  @Autowired
  protected ObjectMapper objectMapper;

  @Autowired
  protected CategoryRepository categoryRepository;

  @Autowired
  protected MemberRepository memberRepository;

  protected Long memberId;
  protected String memberAccount = "account1";
  protected String memberPassword = "password1!";
  protected String memberNickname = "member1";
  protected Boolean memberNotification = true;
  protected String accessToken;
  protected Member member;

  @BeforeEach
  public void setUp() throws Exception {
    createMockMember();
  }

  private void createMockMember() throws Exception {
    member = Member.builder()
        .account(memberAccount)
        .password("$2a$10$VjSR9HyMuosOneqcEysAweOITjRuppgrsG9nR6fdGm/jDKLKJ51zK")
        .nickname(memberNickname)
        .notification(memberNotification)
        .build();
    memberRepository.save(member);
    memberId = member.getId();

    MemberLoginReqDto request = new MemberLoginReqDto(memberAccount, memberPassword);
    MvcResult result = mockMvc.perform(post("/api/members/login")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)))
        .andReturn();

    String response = result.getResponse().getContentAsString();
    System.out.println(response);
    accessToken = JsonPath.parse(response).read("$.access_token");
  }

}
