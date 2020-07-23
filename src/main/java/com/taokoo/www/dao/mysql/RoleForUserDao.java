package com.taokoo.www.dao.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taokoo.www.domain.po.RoleForUser;

public interface RoleForUserDao extends JpaRepository<RoleForUser, Integer> {

}
