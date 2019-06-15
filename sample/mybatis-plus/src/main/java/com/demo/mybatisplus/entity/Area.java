package com.demo.mybatisplus.entity;

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
 * @date: 2019-06-02
 * @description: 
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_area")
@ApiModel(value="Area对象", description="")
public class Area extends IBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地区代码")
    private String code;

    @ApiModelProperty(value = "地区名称")
    private String name;

    @ApiModelProperty(value = "省份代码")
    private String provinceCode;

    @ApiModelProperty(value = "城市代码")
    private String cityCode;

    @ApiModelProperty(value = "县级")
    private String areaCode;

    @ApiModelProperty(value = "村级")
    private String streetCode;


}
