package com.taokoo.www.dao.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taokoo.www.domain.po.team.Activity;

public interface ActivityDao extends JpaRepository<Activity, Integer> {

}
