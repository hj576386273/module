package com.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.demo.entity.base.IBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019-09-12
 * @description: 地区
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_area")
@ApiModel(value="Area对象", description="地区")
public class Area extends IBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地区代码")
    private String areaCode;

    @ApiModelProperty(value = "地区名称")
    private String areaName;

    @ApiModelProperty(value = "地区简称")
    private String shortName;

    @ApiModelProperty(value = "父级id")
    private Integer parentId;

    @ApiModelProperty(value = "父级代码")
    private String parentCode;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "级别")
    private Integer level;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    @ApiModelProperty(value = "地区完整名称")
    private String fullName;

    @ApiModelProperty(value = "地区完整分隔名称")
    private String fullSeparateName;

    @ApiModelProperty(value = "删除标识，-1删除，0正常")
    private Integer isDelete;


}
