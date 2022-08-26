package com.codegym.library.controller;

import com.codegym.library.common.Exception.BookHasNotBeenBorrowed;
import com.codegym.library.common.Exception.NotFoundBook;
import com.codegym.library.model.Book;
import com.codegym.library.service.IBookService;
import com.codegym.library.service.IBookTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LibraryController {

    @Autowired
    private IBookTitleService bookTitleService;

    @Autowired
    private IBookService bookService;

    @GetMapping("/")
    public String goHomePage(Model model){
        model.addAttribute("bookTitleList",this.bookTitleService.findAllBookTitle());
        return "list";
    }

    @GetMapping("/detail")
    public String goDetailPage(@RequestParam int id, Model model){
        model.addAttribute("bookTitle",this.bookTitleService.findBookTitleById(id));
        return "detail";
    }

    @GetMapping("/borrow")
    public String borrow(@RequestParam Integer id,
                         RedirectAttributes redirectAttributes) throws NotFoundBook {

        Book bookBorrow = this.bookService.findBookToBorrow(id);

        if (bookBorrow == null){
            throw new NotFoundBook();
        }else {
            bookBorrow.setStatus(false);
            this.bookService.update(bookBorrow);
            redirectAttributes.addFlashAttribute("mess","Mượn sách thành công");
        }
        return "redirect:/";
    }

    @GetMapping("/return")
    public String goReturnPage(){
        return "/return";
    }

    @PostMapping("/check_return")
    public String returnBook(@RequestParam Integer id,
                             RedirectAttributes redirectAttributes) throws BookHasNotBeenBorrowed, NotFoundBook {
        Book bookReturn = this.bookService.findBookToReturn(id);
        if (bookReturn == null){
            throw new NotFoundBook();
        }else {
            if (bookReturn.isStatus()){
                throw new BookHasNotBeenBorrowed();
            }else {
                bookReturn.setStatus(true);
                this.bookService.update(bookReturn);
                redirectAttributes.addFlashAttribute("mess","Trả sách thành công");
            }
        }
        return "redirect:/return";
    }

    @ExceptionHandler(value = NotFoundBook.class)
    public String goNotFoundBookErr(){
        return "not_found";
    }

    @ExceptionHandler(value = BookHasNotBeenBorrowed.class)
    public String goBookHasNotBeenBorrowedErr(){
        return "borrow_err";
    }
}
