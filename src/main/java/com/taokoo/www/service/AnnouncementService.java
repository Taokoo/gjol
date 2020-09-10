package com.taokoo.www.service;


import com.taokoo.www.domain.po.message.Announcement;

import javax.xml.soap.Text;

public class AnnouncementService {

    public void addAnnouncement(Integer id, String content, String title, String date, String document){
        Announcement announcement = new Announcement();
        announcement.setId(id);
        announcement.setContent(content);
        announcement.setTitle(title);
        announcement.setDate(date);
        announcement.setDocument(document);
    }
}
