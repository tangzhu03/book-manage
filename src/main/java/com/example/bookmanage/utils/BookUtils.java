package com.example.bookmanage.utils;

import com.example.bookmanage.pojo.Book;

/**
 * @author: Mr.Zhou
 * @create: 2020-03-22 23:30
 **/
public class BookUtils {
    private static final ThreadLocal<Book> BOOK_THREAD_LOCAL = new ThreadLocal<>();

    private BookUtils() {

    }

    static {
        BOOK_THREAD_LOCAL.set(new Book());
    }

    public static Book getBook() {
        return BOOK_THREAD_LOCAL.get();
    }

    public static void clean() {
        BOOK_THREAD_LOCAL.remove();
    }
}
