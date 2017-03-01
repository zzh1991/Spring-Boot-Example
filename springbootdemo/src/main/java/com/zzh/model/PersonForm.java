package com.zzh.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by dell on 2017/2/10.
 */
@Data
public class PersonForm {
    // @NotEmpty(message = "Name can't be null")
    // @Length(min = 5, message = "Name must large or equal than 5")
    @NotNull
    @Size(min=2, max=30)
    private String name;

    @NotNull
    @Min(18)
//    @Min(value = 18, message = "Age must be large or equal than 18")
    private int age;
}
