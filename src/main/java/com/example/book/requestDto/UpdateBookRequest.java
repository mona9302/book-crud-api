package com.example.book.requestDto;
import lombok.Data;

@Data
public class UpdateBookRequest {
    
	 private String bookName;
	 private String title;
	 private String authorName;
	 private String bookPrice;
}
