package com.LibraryManagement.LibMgm.Repository;

import com.LibraryManagement.LibMgm.Entitiy.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
}
