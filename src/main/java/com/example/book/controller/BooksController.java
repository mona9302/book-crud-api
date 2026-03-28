package com.example.book.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.bookServiceImpl.BookServiceImpl;
import com.example.book.entity.Books;
import com.example.book.requestDto.BookRequest;
import com.example.book.requestDto.DeleteBookRequest;
import com.example.book.requestDto.UpdateBookRequest;
import com.example.book.responseDto.BookResponseDto;
import com.example.book.responseDto.BookUpdateResponse;
import com.example.book.responseDto.DeleteBookResponse;

@RestController
@RequestMapping("/books")
public class BooksController {
  
	private final BookServiceImpl service;
	
	public BooksController(BookServiceImpl service) {
		this.service = service;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<BookResponseDto> createBooks(@RequestBody BookRequest request){
		return new ResponseEntity<BookResponseDto>(service.saveBooks(request),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DeleteBookResponse> deleteBook(@PathVariable("id")Long id){
		return new ResponseEntity<DeleteBookResponse>(service.deleteBooks(id),HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<BookResponseDto>> showAllBooks(){
		return new ResponseEntity<List<BookResponseDto>>(service.showBooks(),HttpStatus.OK);	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<BookUpdateResponse> updateBooks(@PathVariable Long id , @RequestBody UpdateBookRequest request){
		return new ResponseEntity<BookUpdateResponse>(service.updateBooks(id, request),HttpStatus.OK);
	}
}
