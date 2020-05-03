package com.user;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年06月01日
 * @description: 代码生成工具类
 */
public class GeneratorCode {

    private boolean file_override = false;// 是否覆盖已有文件
    private String author = "huangjian";
    private String[] include = {"t_area"}; // 生成表名
    private DateType date_type = DateType.TIME_PACK; // java8 新的时间类型
    
    private boolean base_resul_tmap = false; // 开启 BaseResultMap
    private boolean base_column_list = false; // 开启 baseColumnList
    private boolean enable_cache = false; //是否在xml中添加二级缓存配置
    
    private String parent_package = "com.user"; // 父包名
    private String project_path = System.getProperty("user.dir"); // 项目路径
    private String table_prefix = "t_"; // 表前缀
    private boolean swagger2 = true; // 开启 swagger2 模式
    private boolean field_annotation_enable = false; // 是否生成实体时，生成字段注解
    private boolean lombok_model = true; //实体】是否为lombok模型（默认 false）
    private boolean builder_model = true; //是否为构建者模型
    private boolean column_constant = false; //是否生成字段常量

    //数据库配置
    private String url = "jdbc:mysql://119.23.52.245:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false";
    private String user_name = "root";
    private String paaword = "root!@#";
    private String driver_name = "com.mysql.cj.jdbc.Driver";

    @Test
    public void generatorCode() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        this.setGlobalConfig(mpg);
        this.setDataSourceConfig(mpg);
        this.setPackageConfig(mpg);
        this.setInjectionConfig(mpg);
        this.setTemplateConfig(mpg);
        this.setStrategyConfig(mpg);
        // 执行代码生成
        mpg.execute();
    }

    /**
     * 全局配置
     *
     * @param mpg
     */
    public void setGlobalConfig(AutoGenerator mpg) {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = project_path;
        gc.setOutputDir(projectPath + "/src/main/java"); // 生成文件的输出目录
        gc.setFileOverride(file_override); // 是否覆盖已有文件
        gc.setEnableCache(enable_cache); // 是否在xml中添加二级缓存配置
        gc.setAuthor(author); // 开发人员
        gc.setSwagger2(swagger2); // 开启 swagger2 模式(实体属性 Swagger2 注解)
        gc.setBaseResultMap(base_resul_tmap); //开启 BaseResultMap
        gc.setBaseColumnList(base_column_list);// 开启 baseColumnList
        gc.setDateType(date_type);
        gc.setOpen(false); //
        //gc.setIdType(IdType.ID_WORKER); 

        gc.setMapperName("%sMapper");
        //gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);
    }

    /**
     * 数据源配置
     *
     * @param mpg
     */
    public void setDataSourceConfig(AutoGenerator mpg) {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url); //驱动连接的URL
        // dsc.setSchemaName("public"); //
        dsc.setDriverName(driver_name); // 驱动名称
        dsc.setUsername(user_name); // 数据库连接用户名
        dsc.setPassword(paaword); // 数据库连接密码
        
        mpg.setDataSource(dsc); //
    }

    /**
     * 包配置
     *
     * @param mpg
     */
    public void setPackageConfig(AutoGenerator mpg) {
        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名")); // 父包模块名
        pc.setParent(parent_package); // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        //pc.setEntity(""); // Entity包名
        //pc.setController(""); //
        //pc.setService(""); //
        //pc.setServiceImpl(""); //
        //pc.setMapper(""); //
        //pc.setPathInfo(); //

        mpg.setPackageInfo(pc);
    }

    /**
     * 自定义配置
     *
     * @param: mpg
     */
    public void setInjectionConfig(AutoGenerator mpg) {

        String projectPath = project_path;
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
            	return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            	//return projectPath + "/src/main/resources/mapper/" + mpg.getPackageInfo().getModuleName()
                //       + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
    }

    /**
     * 模板配置
     * @param: mpg
     */
    public void setTemplateConfig(AutoGenerator mpg) {
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setController("templates/controller.java");
        templateConfig.setEntity("templates/entity.java");
        templateConfig.setService("templates/service.java");
        templateConfig.setServiceImpl("templates/serviceImpl.java");
        templateConfig.setMapper("templates/mapper.java");

        templateConfig.setXml(null); // 这是生成mapper包下的xml
        mpg.setTemplate(templateConfig);
    }

    public void setStrategyConfig(AutoGenerator mpg) {
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体的命名策略  下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行  下划线转驼峰命名
        strategy.setTablePrefix(table_prefix); // 表前缀
        //strategy.setFieldPrefix(""); // 字段前缀
        strategy.setSuperEntityClass("com.demo.entity.base.IBaseEntity"); // 自定义继承的Entity类全称，带包名
        strategy.setSuperEntityColumns("id", "create_by", "create_time", "update_by", "update_time"); // 自定义基础的Entity类，公共字段(数据库字段)
        strategy.setSuperMapperClass("com.demo.tool.base.IBaseMapper"); // 自定义继承的Mapper类全称，带包名
        strategy.setSuperServiceClass("com.demo.tool.base.IBaseService"); // 自定义继承的Service类全称，带包名
        strategy.setSuperServiceImplClass("com.demo.tool.base.IBaseServiceImpl"); // 自定义继承的ServiceImpl类全称，带包名
        strategy.setSuperControllerClass("com.demo.tool.base.IBaseController"); // 自定义继承的Controller类全称，带包名
        strategy.setInclude(include); // 需要包含的表名，允许正则表达式（与exclude二选一配置）
        //strategy.setExclude(""); // 需要排除的表名，允许正则表达式
        strategy.setEntityColumnConstant(column_constant); // 是否生成字段常量
        strategy.setEntityBuilderModel(builder_model); // 是否为构建者模型
        strategy.setEntityLombokModel(lombok_model); // 【实体】是否为lombok模型（默认 false）
        strategy.setEntityBooleanColumnRemoveIsPrefix(false); // Boolean类型字段是否移除is前缀
        strategy.setRestControllerStyle(true); // 生成@RestController 控制器
        strategy.setControllerMappingHyphenStyle(false); // mapping 驼峰转连字符
        strategy.setEntityTableFieldAnnotationEnable(field_annotation_enable); // 是否生成实体时，生成字段注解
        //strategy.setVersionFieldName(""); // 乐观锁属性名称
        //strategy.setLogicDeleteFieldName(""); // 逻辑删除字段名称
        //strategy.setTableFillList(); // 表填充字段

        strategy.setControllerMappingHyphenStyle(true); //
        mpg.setStrategy(strategy); //
        mpg.setTemplateEngine(new FreemarkerTemplateEngine()); //
    }
}
