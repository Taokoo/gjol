package com.taokoo.www.dao.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taokoo.www.domain.po.User;

public interface UserDao extends JpaRepository<User, Integer>{
    List<User> findByUsernameAndPassword(String username, String password);
}
