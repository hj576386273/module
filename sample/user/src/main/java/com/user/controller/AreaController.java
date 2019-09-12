package com.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import com.demo.tool.base.IBaseController;
import com.user.entity.Area;
import com.user.service.AreaService;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019-09-12
 * @description: 地区 前端控制器
 */
@RestController
@RequestMapping("/area")
@Api(value="地区", tags = "地区", description="")
public class AreaController extends IBaseController<AreaService, Area> {

}
