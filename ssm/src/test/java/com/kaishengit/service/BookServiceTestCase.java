package com.kaishengit.service;

import com.kaishengit.pojo.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by 20330 on 2016/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BookServiceTestCase {
    @Inject
    private BookService bookService;
    @Test
    public void testFindAllBook(){
        List<Book> bookList=bookService.findAllBook();
        Assert.assertEquals(bookList.size(),30);

    }
        @Test
        public void testSaveBook(){
            Book book =new Book();
            book.setBookname("大话西游");
            book.setBookauthor("吴承恩");
            book.setBooknum(10);
            book.setBookprice(42.5F);
            book.setPubid(4);
            book.setTypeid(2);
            bookService.saveBook(book);

    }
    @Test
    public void testFindBookById(){
        Book book =bookService.findBookById(1);
        Assert.assertNotNull(book);
    }
    @Test
    public void testUpdateBook(){
        Book book=bookService.findBookById(1);
        book.setBookprice(100F);
        bookService.updateBook(book);
    }
    @Test
    public void testDelBook(){
        bookService.delBook(36);
    }
}
