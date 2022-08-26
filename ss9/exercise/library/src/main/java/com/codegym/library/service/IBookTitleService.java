package com.codegym.library.service;

import com.codegym.library.model.BookTitle;

import java.util.List;

public interface IBookTitleService {

    List<BookTitle> findAllBookTitle();

    BookTitle findBookTitleById(int id);

}
