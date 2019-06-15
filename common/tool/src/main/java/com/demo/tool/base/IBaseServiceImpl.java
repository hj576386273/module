package com.demo.tool.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年06月02日
 * @description: IBaseService 实现类（ 泛型：M 是 mapper 对象，T 是实体)
 */
public class IBaseServiceImpl<M extends IBaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {

    @Autowired
    protected M baseMapper;

    @Override
    public M getIBaseMapper() {
        return baseMapper;
    }
}
