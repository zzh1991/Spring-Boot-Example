package com.zzh.dataDAO;

import com.zzh.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dell on 2017/2/9.
 */
@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Book book) {
        return jdbcTemplate.update("insert into mybook(bookName, price) VALUES (?, ?)",
                book.getBookName(), book.getPrice());
    }

    @Override
    public int update(Book book) {
        return jdbcTemplate.update("UPDATE mybook set bookName = ?, price = ? WHERE id = ?",
                new Object[]{book.getBookName(), book.getPrice(), book.getId()});
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM mybook WHERE id = ?", id);
    }

    @Override
    public Book findBook(int id) {
        List<Book> list = jdbcTemplate.query("select * from yourbook where bookid = ?",
                new Object[]{id}, new BeanPropertyRowMapper<Book>(Book.class));
        if(null != list && list.size()>0){
            Book book = list.get(0);
            return book;
        }else{
            return null;
        }
    }

    @Override
    public List<Book> findBookList() {
        List<Book> list = jdbcTemplate.query("select * from mybook", new Object[]{},
                new BeanPropertyRowMapper<Book>(Book.class));
        return list;
    }
}
