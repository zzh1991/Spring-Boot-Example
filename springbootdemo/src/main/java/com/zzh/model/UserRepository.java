package com.zzh.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by dell on 2017/2/11.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
//    @Query("UPDATE user u set u.name = :name, u.email = :email WHERE u.id = :id")
//    @Modifying
//    void update(@Param("name") String name, @Param("email") String email, @Param("id") Integer id);

}
