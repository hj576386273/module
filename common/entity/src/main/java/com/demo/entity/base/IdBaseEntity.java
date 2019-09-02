package com.demo.entity.base;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年06月02日
 * @description: TODO
 */
@Data
public class IdBaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1513069292803207142L;
	
	@ApiModelProperty(value = "主键id")
    private Long id;

}
