package com.taokoo.www.service;


import com.taokoo.www.dao.mysql.AnnouncementDao;
import com.taokoo.www.domain.po.message.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AnnouncementService {

    @Autowired
    private AnnouncementDao announcementDao;

    public void addAnnouncement(String content, String title, String date, String document){
        Announcement announcement = new Announcement();
        announcement.setContent(content);
        announcement.setTitle(title);
        announcement.setDate(date);
        announcement.setDocument(document);
        announcementDao.save(announcement);
    }
}
