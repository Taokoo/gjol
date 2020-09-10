package com.taokoo.www.task;

import com.taokoo.www.service.AnnouncementService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.io.IOException;


/**
 * 这是一个刷新每日公告的计时器
 * 2020-09-10
 */

@Slf4j
@Component
public class AnnouncementTask {

    @Scheduled(cron = "0 0 0,13,18,21 * * ?")
    public void refresh(){
            String url="http://gjol.wangyuan.com/info/notice.shtml";
            Document document = null;
            try {
                document = Jsoup.connect(url).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements list_box = document.getElementsByClass("list_box");
            Elements a = list_box.get(0).getElementsByTag("li");
            for (Element e : a) {
                StringBuffer buffer = new StringBuffer("http://gjol.wangyuan.com/"); //图片地址的前半段
                String attr = e.getElementsByTag("a").attr("href"); //获取href中的链接
                String str2 = attr.substring(attr.indexOf("2")); //图片地址的后半段
                buffer.append(str2);  //拼出地址新串来
                String content = buffer.toString();
                String[] text = e.text().split(" "); //将li中的所有文本获取拆分成三段 前两段为内容 后一段为日期
                StringBuffer title = new StringBuffer(text[0]);
                title.append(text[1]); // 将内容拼成一段
                String date=text[2];
                System.out.println(title.toString());
                AnnouncementService service = new AnnouncementService();
                service.addAnnouncement(null,content,title.toString(),date, String.valueOf(document));
            }
        }
}
