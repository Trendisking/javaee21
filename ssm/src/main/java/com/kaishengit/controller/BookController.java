package com.kaishengit.controller;

import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import com.kaishengit.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by 20330 on 2016/7/5.
 */
@Controller
@RequestMapping("/books")
public class BookController {
    @Inject
    private BookService bookService;

    @RequestMapping(method= RequestMethod.GET)
    public String list(Model model){
        List<Book> bookList=bookService.findAllBook();
        model.addAttribute("bookList",bookList);
        return  "books/list";
    }
    @RequestMapping(value="/new",method = RequestMethod.GET)
    public String saveBook(Model model){
        //TODO查询所有的分类
        List<BookType> bookTypeList=bookService.findAllBookType();
        model.addAttribute("types",bookTypeList);
        //TODO查询所有的出版社
        List<Publisher> publisherList=bookService.findAllPublisher();
        model.addAttribute("pubs",publisherList);
        return "books/new";
    }
    @RequestMapping(value ="/new",method = RequestMethod.POST)
    public String saveBook(Book book, RedirectAttributes redirectAttributes){
        bookService.saveBook(book);
        redirectAttributes.addFlashAttribute("message","操作成功");
        return "redirect:/books";
    }
    @RequestMapping(value="/{id:\\d+}/del",method = RequestMethod.GET)
    public String delBook(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        bookService.delBook(id);
        redirectAttributes.addFlashAttribute("message","操作成功");
        return "redirect:/books";
    }
    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
    public String editBook(@PathVariable Integer id,Model model){
        Book book=bookService.findBookById(id);
        if(book==null){
            //TODO 404
            throw new NotFoundException();
        }
        model.addAttribute("types",bookService.findAllBookType());
        model.addAttribute("pubs",bookService.findAllPublisher());
        model.addAttribute("book",book);
        return "books/edit";
    }
    @RequestMapping(value ="/{id:\\d+}",method = RequestMethod.POST)
    public String editBook(Book book,RedirectAttributes redirectAttributes){

        bookService.updateBook(book);
        redirectAttributes.addFlashAttribute("message","操作成功");
        return "redirect:/books";
    }
}
