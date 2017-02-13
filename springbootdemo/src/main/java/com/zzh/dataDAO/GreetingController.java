package com.zzh.dataDAO;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dell on 2017/2/10.
 */
@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("book", new Book());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Book book) {
        return "result";
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(String bookName, String price){
//        System.out.println(bookName + ": " + price);
//        return "index";
//    }
}
