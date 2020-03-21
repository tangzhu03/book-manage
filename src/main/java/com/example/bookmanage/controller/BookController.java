package com.example.bookmanage.controller;

import com.example.bookmanage.pojo.Book;
import com.example.bookmanage.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangzhu
 * @date 2020/3/21 1:11 上午
 */
@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("byId/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "id不能为空！");
        Book book = new Book();
        book.setId(Long.valueOf(id));
        Book result = bookService.getBookById(book);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
