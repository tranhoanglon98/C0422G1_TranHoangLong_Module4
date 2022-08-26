package com.codegym.library.repository;

import com.codegym.library.model.BookTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookTitleRepository extends JpaRepository<BookTitle,Integer> {

}
