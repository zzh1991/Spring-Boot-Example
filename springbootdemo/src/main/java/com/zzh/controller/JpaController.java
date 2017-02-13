package com.zzh.controller;

import com.zzh.model.User;
import com.zzh.model.UserRepository;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by dell on 2017/2/11.
 */
@Controller
@RequestMapping(value = "/data/jpa")
public class JpaController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public @ResponseBody User addNewUser (@RequestParam String name
            , @RequestParam String email) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return n;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @PostMapping("/find")
    public @ResponseBody User getUser(String id) {
        User user = userRepository.findOne(Integer.valueOf(id));
        return user;
    }

    @PostMapping("/delete")
    public @ResponseBody User deleteUser(String id) {
        User user = userRepository.findOne(Integer.valueOf(id));
        userRepository.delete(Integer.valueOf(id));
        return user;
    }

    @PostMapping("/update")
    public @ResponseBody User updateUser(User user) {
//        userRepository.update(user.getName(),user.getEmail(),user.getId());
        user = new User(2, "Jack", "jack@mit.edu");
        return user;
    }
}
