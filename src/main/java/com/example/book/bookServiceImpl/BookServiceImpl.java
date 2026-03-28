package com.example.book.bookServiceImpl;
import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.entity.Books;
import com.example.book.repo.IBookRepository;
import com.example.book.requestDto.BookRequest;
import com.example.book.requestDto.UpdateBookRequest;
import com.example.book.responseDto.BookResponseDto;
import com.example.book.responseDto.BookUpdateResponse;
import com.example.book.responseDto.DeleteBookResponse;
import com.example.book.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepository repo;
	
	@Override
	public BookResponseDto saveBooks(BookRequest books) {
		Books book = new Books();
		BeanUtils.copyProperties(books, book);
		Books save = repo.save(book);
		
		BookResponseDto response = new BookResponseDto();
		BeanUtils.copyProperties(save,response);
		System.out.println(response);
		return response;
	}

	public DeleteBookResponse deleteBooks(Long id) {
		if (!repo.existsById(id)) {
	        throw new RuntimeException("Book not found with id: " + id);
	    }

	    repo.deleteById(id);
	    DeleteBookResponse response = new DeleteBookResponse();
	    response.setMessage("Book deleted successfully");
	    return response;
		 
	}

	@Override
	public List<BookResponseDto> showBooks() {

	    List<Books> booksList = repo.findAll();
	    List<BookResponseDto> responseList = new ArrayList<>();

	    for (Books book : booksList) {
	        BookResponseDto dto = new BookResponseDto();
	        BeanUtils.copyProperties(book, dto);
	        responseList.add(dto);
	    }
	    return responseList;
	}

	@Override
	public BookUpdateResponse updateBooks(Long id, UpdateBookRequest request) {
		Books book = repo.findById(id)
	               .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

	       BeanUtils.copyProperties(request, book, "id");
	       Books updatedBook = repo.save(book);
	       BookUpdateResponse response = new BookUpdateResponse();
	       BeanUtils.copyProperties(updatedBook, response);
	       return response;
	}  
	
}

