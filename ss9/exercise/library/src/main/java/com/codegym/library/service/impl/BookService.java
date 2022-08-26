package com.codegym.library.service.impl;

import com.codegym.library.model.Book;
import com.codegym.library.repository.IBookRepository;
import com.codegym.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public void update(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public Book findBookToBorrow(Integer titleId) {
        return this.bookRepository.findBookToBorrow(titleId);
    }

    @Override
    public Book findBookToReturn(Integer bookId) {
        return this.bookRepository.findById(bookId).orElse(null);
    }
}
