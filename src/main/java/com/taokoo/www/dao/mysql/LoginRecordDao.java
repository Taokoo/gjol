package com.taokoo.www.dao.mysql;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taokoo.www.domain.po.user.LoginRecord;


public interface LoginRecordDao extends JpaRepository<LoginRecord, Integer> {
    List<LoginRecord> findByUserIdIn(Set<Integer> userIds);
    List<LoginRecord> findByUserIdInAndTimeBetween(Set<Integer> userIds, Date start, Date end);
}
