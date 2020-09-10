package com.taokoo.www.dao.mysql;

import com.taokoo.www.domain.po.message.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementDao extends JpaRepository<Announcement,Integer> {

}
