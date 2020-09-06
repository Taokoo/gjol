package com.taokoo.www.dao.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taokoo.www.domain.po.user.User;

public interface UserDao extends JpaRepository<User, Integer>{

    //findAll() removeAll()  save();  saveAll();

    List<User> findByUsernameAndPassword(String username, String password);
    
    List<User> findByUsername(String username);

}
