package com.demo.tool.utils;

import lombok.Data;
import lombok.val;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2020年09月17日 21:47
 */
public class BeanUtils {


    public static <T> T copy(Object source, Class<T> clazz){
        if (source == null){
            return null;
        }
        BeanCopier bc = BeanCopier.create(source.getClass(), clazz, false);
        T bean = newInstance(clazz);
        bc.copy(source, bean, null);
        return bean;
    }

    public static <T> List<T> copyList(Collection source, Class<T> clazz){
        if (source.isEmpty()){
            return Collections.emptyList();
        }
        List<T> list = new ArrayList<>(source.size());
        source.forEach(item -> list.add(copy(item, clazz)));
        return list;

    }

    public static <T> T map2Bean(Map<?, ?> source, Class<T> clazz){
        T bean = newInstance(clazz);
        BeanMap map = BeanMap.create(bean);
        map.putAll(source);
        return bean;
    }

    public static <T> Map bean2Map(T bean){
        Map<String, Object> hashMap = new HashMap<>(16);
        BeanMap beanMap = BeanMap.create(bean);
        hashMap.putAll(beanMap);
        return hashMap;
    }

    private static <T> T newInstance(Class<T> clazz){
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        X x = new X();
        x.index = 5;
        Y copy = copy(x, Y.class);
        System.out.println(copy.index);
    }


    @Data
    static class X{
        public Integer index;
    }
    @Data
    static class Y{
        public Integer index;
    }

}
