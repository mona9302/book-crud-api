package com.example.book.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book_tab")
public class Books {
     
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long bookId;
	 
	 @Column(name = "book_name")
	 private String bookName;
	 
	 @Column(name = "book_title")
	 private String title;
	 
	 @Column(name = "author_name")
	 private String authorName;
	 
	 @Column(name = "book_price")
	 private Double bookPrice;
}
