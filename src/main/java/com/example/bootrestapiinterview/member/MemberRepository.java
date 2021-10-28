package com.example.bootrestapiinterview.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
	
	@Query("SELECT m FROM Member m WHERE m.email = ?1")
	Optional<Member> findMemberByEmail(String email);


}
