package com.zzh.dataDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/9.
 */
@Service("bookService")
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDAO bookDAO;

    @Override
    public int add(Book book) {
        return this.bookDAO.add(book);
    }

    @Override
    public int update(Book book) {
        return this.bookDAO.update(book);
    }

    @Override
    public int delete(int id) {
        return this.bookDAO.delete(id);
    }

    @Override
    public Book findBook(int id) {
        return this.bookDAO.findBook(id);
    }

    @Override
    public List<Book> findBookList() {
        return this.bookDAO.findBookList();
    }
}
