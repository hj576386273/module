package com.demo.tool.base;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年06月02日
 * @description: TODO
 */
public interface IBaseService<T> extends IService<T> {

    /**
     * 获取对应 entity 的 IBaseMapper
     * @return
     */
	@SuppressWarnings("rawtypes")
	IBaseMapper getIBaseMapper();

    @SuppressWarnings("unchecked")
	default <E extends T> List<E> selectPage(E entity){
        return getIBaseMapper().selectPage(entity);
    }
}
