package com.zzh.dataDAO;

import java.util.List;

/**
 * Created by dell on 2017/2/9.
 */
public interface BookDAO {
    int add(Book book);
    int update(Book book);
    int delete(int id);
    Book findBook(int id);
    List<Book> findBookList();
}
