package com.demo.mybatisplus.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import com.demo.tool.base.IBaseController;
import com.demo.mybatisplus.entity.Area;
import com.demo.mybatisplus.service.AreaService;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019-09-02
 * @description: 地区 前端控制器
 */
@RestController
@RequestMapping("/area")
@Api(value="地区", tags = "", description="")
public class AreaController extends IBaseController<AreaService, Area> {

}
