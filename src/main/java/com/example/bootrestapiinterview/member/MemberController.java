package com.example.bootrestapiinterview.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "api/v1/member")
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
		// TODO Auto-generated constructor stub
	}

	@GetMapping
	public List<Member> getMembers() {
		return memberService.getMembers();
	}
	
	@PostMapping
	public void registerNewMember(@RequestBody Member member) {
		memberService.addNewMember(member);
	}
	
	@DeleteMapping(path = "{memberId}")
	public void deleteStudent(@PathVariable("memberId") Long memberId) {
		memberService.deleteMember(memberId);
	}
	
	@PutMapping(path = "{memberId}")
	public void updateStudent(
			@PathVariable("memberId") Long studentId,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String name) {
		memberService.updateMember(studentId,email,name);
	}
	
}

