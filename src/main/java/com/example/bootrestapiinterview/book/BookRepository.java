package com.example.bootrestapiinterview.book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	//SELECT * FROM student Where email = ?
	@Query("SELECT b FROM Book b WHERE b.status = ?1")
	Optional<Book> findBookByStatus(String status);

}