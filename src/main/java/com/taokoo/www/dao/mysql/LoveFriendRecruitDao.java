package com.taokoo.www.dao.mysql;

import com.taokoo.www.domain.po.socialContact.LoveFriendRecruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoveFriendRecruitDao extends JpaRepository<LoveFriendRecruit, Integer>  {

    List<LoveFriendRecruit> findByUserRoleId(Integer userRoleId);

    List<LoveFriendRecruit> findById(Integer id);
}
