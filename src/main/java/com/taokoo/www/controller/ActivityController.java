package com.taokoo.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taokoo.www.service.ActivityService;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: ActivityController  
 * @Description: 活动Controller
 * @author Taokoo
 * @date 2020-7-24
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping("/activity")
@CrossOrigin
@Slf4j
public class ActivityController {

	@Autowired
	private ActivityService activityService;
}
