package com.example.book.requestDto;
import lombok.Data;

@Data
public class BookRequest {
   
	private String title;
	private String authorName;
	private Double bookPrice;
	private String bookName;
}
