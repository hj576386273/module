package com.demo.tool.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年06月02日
 * @description: TODO
 */
public abstract class IBaseController<M extends IBaseService<T>, T> {

    @Autowired
    protected M baseService;

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public T insert(@RequestBody T entity){
        boolean save = baseService.save(entity);
        return entity;
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public boolean delete(@RequestBody Serializable id){
        return baseService.removeById(id);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public boolean update(@RequestBody T entity){
        return baseService.updateById(entity);
    }

    @RequestMapping(path = "/selectById", method = RequestMethod.GET)
    public T selectById(Long id){
        return baseService.getById(id);
    }

    @RequestMapping(path = "/selectPage", method = RequestMethod.GET)
    public <E extends T> List<E> selectPage(E entity){
        return baseService.selectPage(entity);
    }


}
