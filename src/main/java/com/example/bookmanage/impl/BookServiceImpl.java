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
        return bookMapper.select(book);
    }

    @Override
    public List<Book> getBooksByFloor(Book book) {
        return bookMapper.select(book);
    }

    @Override
    public List<Book> getBooksByShelf(Book book) {
        return bookMapper.select(book);
    }

    @Override
    public List<Book> getBooksByShelfFloor(Book book) {
        return bookMapper.select(book);
    }

    @Override
    public Book getBookById(Book book) {
        return bookMapper.selectOne(book);
    }

    @Override
    public Book getBookByName(Book book) {
        return bookMapper.selectOne(book);
    }

    @Override
    public List<Book> getBooksByRoom(Book book) {
        return bookMapper.select(book);
    }

    @Override
    public List<Book> getBooksByAuthor(Book book) {
        return bookMapper.select(book);
    }

    @Override
    public void insertBook(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public void editBook(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public void insertBookList(List<Book> books) {
        for (Book book : books) {
            bookMapper.insert(book);
        }
    }

    @Override
    public void deleteBookById(Book book) {
        bookMapper.deleteByPrimaryKey(book);
    }
}
