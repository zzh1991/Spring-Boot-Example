package com.zzh.controller;


import com.zzh.dataDAO.BookService;
import com.zzh.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/9.
 */
@RestController
@RequestMapping(value = "/data/jdbc/book")
public class BookController  {
    @Autowired
    private BookService bookService;

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Book add(@RequestBody JSONObject jsonObject){
//        try {
//            String bookId = jsonObject.getString("id");
//            String bookName = jsonObject.getString("bookName");
//            double price = jsonObject.getDouble("price");
//            Book book = new Book();
//            if (book != null) {
//                book.setId(Integer.valueOf(bookId));
//                book.setBookName(bookName);
//                book.setPrice(price);
//                this.bookService.add(book);
//            }
//            return book;
//        }catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("add error!");
//        }
//    }



    @RequestMapping(value = "/getBookList", method = RequestMethod.GET)
    public Map<String,Object> getBookList(HttpServletRequest request) {
        List<Book> bookList = this.bookService.findBookList();
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("total", bookList.size());
        param.put("rows", bookList);
        return param;
    }


    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Integer id, HttpServletRequest request) {
        Book book = this.bookService.findBook(id);
        if(book == null){
            throw new RuntimeException("query error!");
        }
        return book;
    }

//    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.PUT)
//    public void update(@PathVariable Integer id, @RequestBody JSONObject jsonObject) {
//        Book book = this.bookService.findBook(id);
//        String bookName = jsonObject.getString("bookName");
//        double price = jsonObject.getDouble("price");
//        book.setBookName(bookName);
//        book.setPrice(price);
//        try{
//            this.bookService.update(book);
//        }catch(Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("update error!");
//        }
//    }

//    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable int id) {
//        try {
//            this.bookService.delete(id);
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("delete error!");
//        }
//    }

    private static final String template = "Hello, %s!";

//    @RequestMapping("/greeting")
//    public Book greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        Book book = new Book();
//        book.setId(3);
//        book.setBookName(String.format(template, name));
//        book.setPrice(100.0);
//        return book;
//    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
//        Book book = new Book();
//        book.setId(3);
//        book.setBookName("Greeting Spring Boot");
//        book.setPrice(100.0);
        model.addAttribute("book", new Book());
        return "greeting";
    }

    @PostMapping("/greeting")
    public Book greetingSubmit(@ModelAttribute Book book) {
        return book;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Book add(String id, String bookName, String price){
        System.out.println(bookName + ": " + price);
        Book book = new Book();
//        book.setId(10);
        book.setBookName(bookName);
        book.setPrice(Float.valueOf(price));
        this.bookService.add(book);
        return book;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Book update(Book book) {
        try {
//            Book book = new Book();
//            book.setId(Integer.valueOf(id));
//            book.setBookName(bookName);
//            book.setPrice(Float.valueOf(price));
            this.bookService.update(book);
            return book;
        }catch (Exception e) {
            throw new RuntimeException("update error!");
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Book delete(String id) {
        try {
            Book book = this.bookService.findBook(Integer.valueOf(id));
            this.bookService.delete(Integer.valueOf(id));
            return book;
        }catch (Exception e) {
            throw new RuntimeException("delete error!");
        }
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Book query(HttpServletRequest request) {
        String id = request.getParameter("id");
        Book book = this.bookService.findBook(Integer.valueOf(id));
        if(book == null){
            throw new RuntimeException("query error!");
        }
        return book;
    }

}
