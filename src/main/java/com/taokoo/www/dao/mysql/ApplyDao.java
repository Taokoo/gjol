package com.taokoo.www.dao.mysql;

import com.taokoo.www.domain.po.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyDao extends JpaRepository<Apply, Integer> {
}
