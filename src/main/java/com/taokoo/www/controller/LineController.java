//package com.taokoo.www.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import cn.landfun.www.annotation.Authentication;
//import cn.landfun.www.annotation.CurrentUser;
//import cn.landfun.www.domain.po.AuthenticatedUser;
//import cn.landfun.www.domain.po.SubwayLine;
//import cn.landfun.www.domain.vo.Result;
//import cn.landfun.www.domain.vo.WorstVo;
//import cn.landfun.www.service.LineService;
//import cn.landfun.www.service.MeqiService;
//import cn.landfun.www.service.SubwayLineSectionService;
//import cn.landfun.www.service.SubwayLineService;
//import cn.landfun.www.service.SubwayLineStationService;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@RequestMapping("/line")
//@CrossOrigin
//@Slf4j
//public class LineController {	
//    
//    @Autowired
//    private SubwayLineService subwayLineService;
//    
//    @Autowired
//    private SubwayLineStationService subwayLineStationService;
//    
//    @Autowired
//    private SubwayLineSectionService subwayLineSectionService;
//    
//    @Autowired
//    private MeqiService meqiService;
//    
//    @Autowired
//    private LineService lineService;
//    
//    
//    @ApiOperation(value = "获取地铁线路列表")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
//})
//    @GetMapping("/lst")
//    @Authentication
//    public Result getLineList(@CurrentUser AuthenticatedUser authenticatedUser) {
//    	List<SubwayLine> lst = subwayLineService.findAll();
//    	return Result.success(lst);
//    }
//    
//    @ApiOperation(value = "获取地铁站/区间的MEQI指数")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
//        @ApiImplicitParam(name = "id", value = "地铁站或区间id", required = true, dataType = "Integer", paramType = "query"),
//        @ApiImplicitParam(name = "type", value = "类型（1：站点，2：区间）", required = true, dataType = "Integer", paramType = "query"),
//})
//    @GetMapping("/getStationMEQI")
//    @Authentication
//    public Result getStationMEQI(@CurrentUser AuthenticatedUser authenticatedUser,Integer id,Integer type) {
//    	return Result.success(meqiService.getMeqi(id, type));
//    }
//    
//    @ApiOperation(value = "获取当前地铁线路中最差站点和最差区间（station为站点，section为区间）(返回值中type：1为站点，2为区间)")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
//        @ApiImplicitParam(name = "lineId", value = "地铁线id", required = true, dataType = "Integer", paramType = "query"),
//})
//    @GetMapping("/getWorst")
//    @Authentication
//    public Result getWorst(@CurrentUser AuthenticatedUser authenticatedUser,Integer lineId) {
//    	return Result.success(lineService.getWorst(lineId));
//    }
//    
//    @ApiOperation(value = "根据地铁线路id获取该线路的站点列表和区间列表（type区分站点和区间）")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
//        @ApiImplicitParam(name = "lineId", value = "地铁线id", required = true, dataType = "Integer", paramType = "query"),
//})
//    @GetMapping("/getStationLst")
//    @Authentication
//    public Result getStationLst(@CurrentUser AuthenticatedUser authenticatedUser,Integer lineId) {
//    	List<WorstVo> lstStation = subwayLineStationService.getLstByLineId(lineId);//站点lst
//    	List<WorstVo> lstSection = subwayLineSectionService.getLstByLineId(lineId);//区间lst
//    	
//    	lstStation.addAll(lstSection);
//    	lstStation.sort((x, y) -> Integer.compare(Integer.valueOf(x.getOrderNo()), Integer.valueOf(y.getOrderNo())));
//    	
//    	return Result.success(lstStation);
//    }
//}
