package com.demo.tool.base;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.tool.utils.ValidationUtils;

import io.swagger.annotations.ApiOperation;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年06月02日
 * @description: TODO
 */
public abstract class IBaseController<M extends IBaseService<T>, T> {

    @Autowired
    protected M baseService;

    @ApiOperation(value = "保存", notes = "")
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public boolean save(@RequestBody T entity){
        this.checkSave(entity);
    	boolean save = baseService.save(entity);
        return save;
    }
    
    @ApiOperation(value = "批量保存", notes = "")
    @RequestMapping(path = "/save-batch", method = RequestMethod.POST)
    public boolean saveBatch(Collection<T> entityList){
        this.checkSaveBatch(entityList);
    	boolean save = baseService.saveBatch(entityList);
        return save;
    }
    
    @ApiOperation(value = "保存或更新", notes = "id有则更新, 没有新增")
    @RequestMapping(path = "/save-or-update", method = RequestMethod.POST)
    public boolean saveOrUpdate(@RequestBody T entity) {
        this.checkSaveOrUpdate(entity);
    	return baseService.saveOrUpdate(entity);
    }
    
    @ApiOperation(value = "批量保存或更新", notes = "")
    @RequestMapping(path = "/save-or-update-batch", method = RequestMethod.POST)
    public boolean saveOrUpdateBatch(Collection<T> entityList) {
    	this.checkSaveOrUpdateBatch(entityList);
    	return baseService.saveOrUpdateBatch(entityList);
    }

    @ApiOperation(value = "删除", notes = "根据主键id删除")
    @RequestMapping(path = "/remove", method = RequestMethod.POST)
    public boolean remove(@RequestBody Serializable id){
        return baseService.removeById(id);
    }
    
    @ApiOperation(value = "批量删除", notes = "")
    @RequestMapping(path = "/remove-batch", method = RequestMethod.POST)
    public boolean removeBatch(@RequestBody Collection<? extends Serializable> idList){
        return baseService.removeByIds(idList);
    }

    @ApiOperation(value = "更新", notes = "根据主键更新不为null的字段")
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public boolean update(@RequestBody T entity){
        this.checkUpdate(entity);
    	return baseService.updateById(entity);
    }
    
    @ApiOperation(value = "批量更新", notes = "")
    @RequestMapping(path = "/update-batch", method = RequestMethod.POST)
    public boolean updateBatch(Collection<T> entityList) {
        return baseService.updateBatchById(entityList);
    }

    @ApiOperation(value = "根据id查询", notes = "")
    @RequestMapping(path = "/selectById", method = RequestMethod.GET)
    public T selectById(@RequestParam("id") Serializable id){
        return baseService.getById(id);
    }
    
    @ApiOperation(value = "根据id批量查询", notes = "")
    @RequestMapping(path = "/list-by-ids", method = RequestMethod.GET)
    public Collection<T> listByIds(@RequestParam("ids") Collection<? extends Serializable> ids){
        return baseService.listByIds(ids);
    }
    
    /**
     * save 参数校验
     * @param entity
     */
    private void checkSave(T entity) {
    	ValidationUtils.validate(entity);
    }
    
    /**
     * SaveBatch 参数校验
     * @param entity
     */
    private void checkSaveBatch(Collection<T> entityList){
    	ValidationUtils.validate(entityList);
    }
    
    /**
     * SaveOrUpdate 参数校验
     * @param entity
     */
    private void checkSaveOrUpdate(T entity){
    	ValidationUtils.validate(entity);
    }
    
    /**
     * SaveOrUpdateBatch 参数校验
     * @param entity
     */
    private void checkSaveOrUpdateBatch(Collection<T> entityList){
    	ValidationUtils.validate(entityList);
    }
    
    /**
     * update 参数校验
     * @param entity
     */
    private void checkUpdate(T entity) {
    	ValidationUtils.validate(entity);
    }
    

	/*
	 * @RequestMapping(path = "/selectPage", method = RequestMethod.GET) public <E
	 * extends T> List<E> selectPage(E entity){ return
	 * baseService.selectPage(entity); }
	 */


}
