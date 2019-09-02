package ${package.Controller};


import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>

<#if swagger2>
import io.swagger.annotations.Api;
</#if>

<#if superControllerClassPackage??>
import ${superControllerClassPackage};
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
</#if>

/**
 * @author ${author}
 * @version 1.0
 * @date: ${date}
 * @description: ${table.comment!} 前端控制器
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if swagger2>
@Api(value="${table.comment!}", tags = "", description="")
</#if>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass}<${table.serviceName}, ${entity}> {
<#else>
public class ${table.controllerName} {
</#if>

}
</#if>
