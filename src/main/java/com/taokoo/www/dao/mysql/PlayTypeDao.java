package com.taokoo.www.dao.mysql;

import com.taokoo.www.domain.po.enumData.PlayType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayTypeDao extends JpaRepository<PlayType, Integer>  {

    List<PlayType> findById(Integer id);
}
