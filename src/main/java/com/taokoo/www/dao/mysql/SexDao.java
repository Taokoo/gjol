package com.taokoo.www.dao.mysql;

import com.taokoo.www.domain.po.enumData.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SexDao extends JpaRepository<Sex, Integer> {

    List<Sex> findById(Integer id);
}
