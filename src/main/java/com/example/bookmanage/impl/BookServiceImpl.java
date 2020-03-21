package com.example.bookmanage.impl;

import com.example.bookmanage.mapper.BookMapper;
import com.example.bookmanage.pojo.Book;
import com.example.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tangzhu
 * @date 2020/3/21 1:11 上午
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBooksByPress(Book book) {
        return null;
    }

    @Override
    public List<Book> getBooksByFloor(Book book) {
        return null;
    }

    @Override
    public List<Book> getBooksByShelf(Book book) {
        return null;
    }

    @Override
    public List<Book> getBooksByShelfFloor(Book book) {
        return null;
    }

    @Override
    public Book getBookById(Book book) {
        return bookMapper.selectOne(book);
    }

    @Override
    public Book getBookByName(Book book) {
        return null;
    }

    @Override
    public List<Book> getBooksByRoom(Book book) {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(Book book) {
        return null;
    }

    @Override
    public void insertBook(Book book) {

    }

    @Override
    public void editBook(Book book) {

    }

    @Override
    public void insertBookList(List<Book> books) {

    }

    @Override
    public void deleteBookById(Book book) {

    }
}
