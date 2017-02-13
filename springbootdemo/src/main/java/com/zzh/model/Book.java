package com.zzh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dell on 2017/2/9.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String bookName;
    private float price;


}
