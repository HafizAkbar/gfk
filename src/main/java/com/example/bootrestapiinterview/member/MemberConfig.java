package com.example.bootrestapiinterview.member;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MemberConfig {

	@Bean
	CommandLineRunner commandLineRunnerMember(MemberRepository repository) {
		return args ->{
			
			Member a = new Member("Mariam","mariam@gmail.com",21,LocalDate.of(2000, Month.JUNE, 6));
			Member b = new Member("Adam","adam@gmail.com",21,LocalDate.of(2004, Month.JUNE, 6));
			
			List<Member> member = new ArrayList<Member>(); 

			member.add(a);
			member.add(b);
			repository.saveAll(member);
		};
	}

}
