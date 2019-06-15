package com.demo.tool.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年06月02日
 * @description: TODO
 */
public interface IBaseMapper<T> extends BaseMapper<T> {

    /**
     * 分页查询
     * @param: entity
     * @return: java.util.List<E>
     */
    <E extends T> List<E> selectPage(E entity);
}
