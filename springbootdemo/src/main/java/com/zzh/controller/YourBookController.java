package com.zzh.controller;

import com.zzh.dao.YourBookService;
import com.zzh.model.YourBook;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@RestController
@RequestMapping("/data/mybatis")
@MapperScan("com.zzh.dao")
public class YourBookController {
    @Autowired
    private YourBookService yourBookService;

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public YourBook getBook(HttpServletRequest request) {
        String bookid = request.getParameter("bookid");
        return this.yourBookService.findBook(Integer.valueOf(bookid));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(String bookName, String price) {
        this.yourBookService.addBook(bookName, Float.valueOf(price));
        return "add Success";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBook(String bookName, String price, String bookid) {
        this.yourBookService.updateBook(bookName, Float.valueOf(price), Integer.valueOf(bookid));
        return "update Success";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteBook(String bookid) {
        this.yourBookService.deleteBook(Integer.valueOf(bookid));
        return "delete Success";
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public List<YourBook> findBookList() {
        return this.yourBookService.findBookList();
    }
}
