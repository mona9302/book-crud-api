package com.example.book.responseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
   
	 private Long id;
	 private String title;
	 private String authorName;
	 private Double bookPrice;
	 private String bookName;
}
