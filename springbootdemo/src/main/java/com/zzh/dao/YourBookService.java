package com.zzh.dao;

import com.zzh.model.YourBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service
public class YourBookService {
    @Autowired
    private YouBookMapper youBookMapper;

    public YourBook findBook(Integer bookid) {
        return this.youBookMapper.findBook(bookid);
    }

    public int addBook(String bookName, Float price){
        return this.youBookMapper.addBook(bookName, price);
    }

    public int updateBook(String bookName, Float price, Integer bookid) {
        return this.youBookMapper.updateBook(bookName, price, bookid);
    }

    public int deleteBook(Integer bookid) {
        return this.youBookMapper.deleteBook(bookid);
    }

    public List<YourBook> findBookList() {
        return this.youBookMapper.findBookList();
    }
}
