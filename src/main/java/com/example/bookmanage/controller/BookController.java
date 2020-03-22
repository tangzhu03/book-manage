package com.example.bookmanage.controller;

import com.example.bookmanage.pojo.Book;
import com.example.bookmanage.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tangzhu
 * @date 2020/3/21 1:11 上午
 */
@RestController
@RequestMapping("books")
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    /**
     * 通过id查询
     */
    @GetMapping("getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "id不能为空！");
        Book book = new Book();
        Long idNumber = null;
        try {
            idNumber = Long.valueOf(id);
        } catch (NumberFormatException e) {
            LOGGER.error("输入的id不正确", e);
        }
        book.setId(idNumber);
        Book result = bookService.getBookById(book);
        LOGGER.info("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 通过书名查询
     */
    @GetMapping("getBookByName/{name}")
    public ResponseEntity<Book> getBookByName(@PathVariable("name") String name) {
        Assert.isTrue(StringUtils.isNotBlank(name), "书名不能为空！");
        Book book = new Book();
        book.setName(name);
        Book result = bookService.getBookByName(book);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 通过出版社查询
     */
    @GetMapping("getBooksByPress/{press}")
    public ResponseEntity<List<Book>> getBooksByPress(@PathVariable("press") String press) {
        Assert.isTrue(StringUtils.isNotBlank(press), "出版社不能为空！");
        Book book = new Book();
        book.setPress(press);
        List<Book> booksByPress = bookService.getBooksByPress(book);
        return new ResponseEntity<>(booksByPress, HttpStatus.OK);
    }

    /**
     * 查询某一楼层所有书籍
     */
    @GetMapping("getBooksByFloor/{floor}")
    public ResponseEntity<List<Book>> getBooksByFloor(@PathVariable("floor") String floor) {
        Assert.isTrue(StringUtils.isNotBlank(floor), "楼层不能为空！");
        Book book = new Book();
        Integer floorNumber = Integer.valueOf(floor);
        book.setFloor(floorNumber);
        List<Book> booksByPress = bookService.getBooksByFloor(book);
        return new ResponseEntity<>(booksByPress, HttpStatus.OK);
    }

    /**
     * 通过书架获取书籍(整个书架)
     *
     * @param row 排
     * @param col 列
     * @return 该书架上所有书籍
     */
    @GetMapping("getBooksByShelf/{row}/{col}")
    public ResponseEntity<List<Book>> getBooksByShelf(@PathVariable("row") String row, @PathVariable("col") String col) {
        Assert.isTrue(StringUtils.isNotBlank(row) && StringUtils.isNotBlank(col), "书架编号不能为空！");
        Book book = new Book();
        Integer rowNumber = Integer.valueOf(row);
        Integer colNumber = Integer.valueOf(col);
        book.setRow(rowNumber);
        book.setCol(colNumber);
        List<Book> booksByPress = bookService.getBooksByShelf(book);
        return new ResponseEntity<>(booksByPress, HttpStatus.OK);
    }

    /**
     * 通过书架获取书籍(书架某一层)
     *
     * @param row   排
     * @param col   列
     * @param floor 层号
     * @return 该书架某层上所有书籍
     */
    @GetMapping("getBooksByShelfFloor/{row}/{col}/{floor}")
    public ResponseEntity<List<Book>> getBooksByShelfFloor(@PathVariable("row") String row, @PathVariable("col") String col, @PathVariable("floor") String floor) {
        Assert.isTrue(StringUtils.isNotBlank(row) && StringUtils.isNotBlank(col) && StringUtils.isNotBlank(floor), "书架编号和书架层号不能为空！");
        Book book = new Book();
        Integer rowNumber = Integer.valueOf(row);
        Integer colNumber = Integer.valueOf(col);
        Integer floorNumber = Integer.valueOf(floor);
        book.setRow(rowNumber);
        book.setCol(colNumber);
        book.setBookshelfFloor(floorNumber);
        List<Book> booksByPress = bookService.getBooksByShelfFloor(book);
        return new ResponseEntity<>(booksByPress, HttpStatus.OK);
    }

    /**
     * 查询某个房间内所有书籍
     */
    @GetMapping("getBooksByRoom/{room}")
    public ResponseEntity<List<Book>> getBooksByRoom(@PathVariable("room") String room) {
        Assert.isTrue(StringUtils.isNotBlank(room), "房间号不能为空！");
        Book book = new Book();
        book.setRoom(room);
        List<Book> booksByPress = bookService.getBooksByRoom(book);
        return new ResponseEntity<>(booksByPress, HttpStatus.OK);
    }

    /**
     * 通过作者查询
     */
    @GetMapping("getBooksByAuthor/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("author") String author) {
        Assert.isTrue(StringUtils.isNotBlank(author), "作者姓名不能为空！");
        Book book = new Book();
        book.setAuthor(author);
        List<Book> booksByPress = bookService.getBooksByAuthor(book);
        return new ResponseEntity<>(booksByPress, HttpStatus.OK);
    }

    @DeleteMapping("deleteBookById/{id}")
    public void deleteBookById(@PathVariable("id") String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "id不能为空!");
        Book book = new Book();
        Long idNumber = null;
        try {
            idNumber = Long.valueOf(id);
        } catch (NumberFormatException e) {
            LOGGER.error("输入的id不正确", e);
        }
        book.setId(idNumber);
        bookService.deleteBookById(book);
    }
}
