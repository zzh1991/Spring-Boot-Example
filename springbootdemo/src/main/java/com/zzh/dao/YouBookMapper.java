package com.zzh.dao;

import com.zzh.model.YourBook;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Mapper
public interface YouBookMapper {
    @Select("select * from yourbook where bookid = #{bookid}")
    YourBook findBook(@Param("bookid") Integer bookid);

    @Insert("insert into yourbook(bookName, price) values(#{bookName}, #{price})")
    int addBook(@Param("bookName") String bookName, @Param("price") Float price);

    @Update("update yourbook set bookName = #{bookName}, price = #{price} where bookid = #{bookid}")
    int updateBook(@Param("bookName") String bookName, @Param("price") Float price, @Param("bookid") Integer bookid);

    @Delete("delete from yourbook where bookid = #{bookid}")
    int deleteBook(@Param("bookid") Integer bookid);

    @Select("select * from yourbook")
    List<YourBook> findBookList();
}
