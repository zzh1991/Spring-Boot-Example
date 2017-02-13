package com.zzh.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by dell on 2017/2/11.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
//    @Query("UPDATE user set name = ?1, email = ?2 WHERE id = ?3")
//    void update(String name, String email, Integer id);
}
