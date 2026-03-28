package com.example.book.service;
import java.util.List;

import com.example.book.requestDto.BookRequest;
import com.example.book.requestDto.UpdateBookRequest;
import com.example.book.responseDto.BookResponseDto;
import com.example.book.responseDto.BookUpdateResponse;
import com.example.book.responseDto.DeleteBookResponse;

public interface IBookService {
   
	public BookResponseDto saveBooks(BookRequest books);
	public DeleteBookResponse deleteBooks(Long id);
	public List<BookResponseDto> showBooks();
	public BookUpdateResponse updateBooks(Long id,UpdateBookRequest request);
}
