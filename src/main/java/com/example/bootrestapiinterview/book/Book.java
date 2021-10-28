package com.example.bootrestapiinterview.book;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Book {

	@Id
	@SequenceGenerator(
			name = "book_sequence",
			sequenceName = "book_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "book_sequence"
			)
	private Long id;
	private String name;
	private String status;
	private String borrower;
	
	public Book() {
		super();
	}	
	
	public Book(Long id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public Book(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	
	@OneToMany
	@JoinColumn(name = "borrower", referencedColumnName = "ID")
	private List<Book> books;
	
	
}
