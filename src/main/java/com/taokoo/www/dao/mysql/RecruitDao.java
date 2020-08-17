package com.taokoo.www.dao.mysql;

import com.taokoo.www.domain.po.team.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitDao extends JpaRepository<Recruit, Integer> {

    List<Recruit> findById(Integer id);
}
