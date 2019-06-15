package com.demo.entity.base;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年06月02日
 * @description: TODO
 */
@Data
public class IBaseEntity implements Serializable {

    /**
     * serialVersionUID:
     */
    private static final long serialVersionUID = -4575837474922480870L;

    @ApiModelProperty(value = "主键id")
    private Long id;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新人")
    private Date updateBy;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}