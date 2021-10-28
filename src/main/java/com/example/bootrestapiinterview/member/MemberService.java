package com.example.bootrestapiinterview.member;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	


	@Transactional
	public void updateMember(Long memberId, String email, String name) {
		// TODO Auto-generated method stub
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new IllegalStateException(
						"Member with id "+ memberId + " does not exist"));
		
		if(name != null &&
				name.length() > 0 &&
				!Objects.equals(member.getName(), name)) {
			member.setName(name);
		}
		
		if(email != null &&
				email.length() > 0 &&
				!Objects.equals(member.getEmail(), email)) {
			Optional<Member> studentOptional = memberRepository.findMemberByEmail(email);
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			member.setEmail(email);
		}
		
	}

	public void deleteMember(Long memberId) {
		boolean exists = memberRepository.existsById(memberId);
		
		if(!exists) {
			throw new IllegalStateException("Member with ID "+ memberId + "does not exist");
		}
		memberRepository.deleteById(memberId);
		
		
		
	}

	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return memberRepository.findAll();
	}


	public void addNewMember(Member member) {
		Optional<Member> memberOptional = memberRepository.findMemberByEmail(member.getEmail());
		
		if(memberOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		memberRepository.save(member);
	}
	

}
