package com.codegym.library.repository;

import com.codegym.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select b.id,b.status,b.title_id from book b join book_title bt on b.title_id = bt.id " +
            "where bt.id = :title_id and b.status = 1 limit 1;", nativeQuery = true)
    Book findBookToBorrow(@Param("title_id") Integer titleId);
}
