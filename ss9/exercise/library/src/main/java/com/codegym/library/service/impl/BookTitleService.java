package com.codegym.library.service.impl;

import com.codegym.library.model.BookTitle;
import com.codegym.library.repository.IBookTitleRepository;
import com.codegym.library.service.IBookTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTitleService implements IBookTitleService {

    @Autowired
    private IBookTitleRepository bookTitleRepository;

    @Override
    public List<BookTitle> findAllBookTitle() {
        return this.bookTitleRepository.findAll();
    }

    @Override
    public BookTitle findBookTitleById(int id) {
        return this.bookTitleRepository.findById(id).get();
    }
}
