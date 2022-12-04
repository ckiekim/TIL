package com.example.demo.service;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;

class MemberServiceTest {
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void 회원가입() {
		// given
		Member member = new Member();
		member.setName("hello");
		
		// when
		int saveId = memberService.join(member);
		
		// then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName().equals(findMember.getName()));
	}
	
	@Test
	public void 중복회원_예외() {
		// given
		Member m1 = new Member();
		m1.setName("spring");
		Member m2 = new Member();
		m2.setName("spring");
		
		// when
		memberService.join(m1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(m2));
		
		// then
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
//		try {
//			memberService.join(m2);
//			fail("예외가 발생해야 합니다.");
//		} catch (IllegalStateException e) {		// then
//			assertThat(e.getMessage().equals("이미 존재하는 회원입니다."));
//		}
	}

}
