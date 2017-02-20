package com.zzh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dell on 2017/2/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YourBook {
    private int bookid;
    private String bookName;
    private float price;
    private int typeid;
}
