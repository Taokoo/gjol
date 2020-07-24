package com.taokoo.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taokoo.www.dao.mysql.ActivityDao;

@Component
public class ActivityService {

	@Autowired
	private ActivityDao activityDao;
	
}
