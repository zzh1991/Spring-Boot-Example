package com.zzh.dataDAO;

import com.zzh.model.Book;

import java.util.List;

/**
 * Created by dell on 2017/2/9.
 */
public interface BookService {
    int add(Book book);
    int update(Book book);
    int delete(int id);
    Book findBook(int id);
    List<Book> findBookList();
}
