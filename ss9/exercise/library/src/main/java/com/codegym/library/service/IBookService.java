package com.codegym.library.service;

import com.codegym.library.model.Book;

public interface IBookService {

    void update(Book book);

    Book findBookToBorrow(Integer titleId);

    Book findBookToReturn(Integer bookId);
}
