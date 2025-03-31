package com.LibraryManagement.LibMgm.Service;


import com.LibraryManagement.LibMgm.Entitiy.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long bookId);
    void deleteBook(Long bookId);
}

