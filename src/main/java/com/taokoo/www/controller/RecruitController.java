package com.taokoo.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taokoo.www.domain.vo.Result;
import com.taokoo.www.service.RecruitService;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: RecruitController  
 * @Description: 固定团招募Controller
 * @author Taokoo
 * @date 2020-7-30
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping("/recruit")
@CrossOrigin
@Slf4j
public class RecruitController {

	@Autowired
	private RecruitService recruitService;
	
	public Result openRecruit() {
		return recruitService.openRecruit();
	}
}
