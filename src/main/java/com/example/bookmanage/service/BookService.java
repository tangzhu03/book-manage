package com.example.bookmanage.service;

import com.example.bookmanage.pojo.Book;

import java.util.List;

/**
 * @author tangzhu
 * @date 2020/3/21 1:10 上午
 */
public interface BookService {
    /**
     * 通过出版社查询书籍
     */
    List<Book> getBooksByPress(Book book);

    /**
     * 通过楼层查询书籍
     */
    List<Book> getBooksByFloor(Book book);

    /**
     * 通过书架（整个书架）查询书籍
     */
    List<Book> getBooksByShelf(Book book);

    /**
     * 通过书架（书架的某一层）查询书籍
     */
    List<Book> getBooksByShelfFloor(Book book);

    /**
     * 通过id查询书籍
     */
    Book getBookById(Book book);

    /**
     * 通过书名查询书籍
     */
    Book getBookByName(Book book);

    /**
     * 通过房间查询书籍
     */
    List<Book> getBooksByRoom(Book book);

    /**
     * 通过作者查询书籍
     */
    List<Book> getBooksByAuthor(Book book);

    /**
     * 插入书籍
     */
    void insertBook(Book book);

    /**
     * 修改书籍
     */
    void editBook(Book book);

    /**
     * 批量插入书籍
     */
    void insertBookList(List<Book> books);

    /**
     * 通过id删除书籍
     */
    void deleteBookById(Book book);
}
