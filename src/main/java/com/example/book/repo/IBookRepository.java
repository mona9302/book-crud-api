package com.example.book.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.entity.Books;

public interface IBookRepository extends JpaRepository<Books, Long> {

}
