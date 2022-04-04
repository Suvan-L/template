package com.template;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

/**
 * 构建生成数据模型
 */
public class MybatisPlusCodeGenerator {

    @Test
    public void generate(){
        // 数据库
        String database = "test";
        String overlook_table_prefix = "t_";
        String author = "amdin";

        String [] tables = {"t_student"};
        boolean isFileOveride = true;

        // 循环数据表，逐个生成映射
        for (String tableName: tables) {
            AutoGenerator autoGenerator = new AutoGenerator();

            //全局配置
            GlobalConfig globalConfig = new GlobalConfig();

            // 当前工程目录
            String projectPath = System.getProperty("user.dir");
                globalConfig.setOutputDir(projectPath + "/src/main/java");

                globalConfig.setAuthor(author);
                //globalConfig.setOpen(true);
                globalConfig.setBaseResultMap(true);
                globalConfig.setBaseColumnList(true);

                // 是否覆盖源文件
                globalConfig.setFileOverride(isFileOveride);

                // 设置 DO 对象后缀
                globalConfig.setEntityName("%sDO");
                globalConfig.setServiceName("%sDAOService");
                globalConfig.setServiceImplName("%sDAOServiceImpl");

                autoGenerator.setGlobalConfig(globalConfig);

                //数据源配置
                DataSourceConfig dataSourceConfig = new DataSourceConfig();
                dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/" + database + "?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
                dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
                dataSourceConfig.setUsername("root");
                dataSourceConfig.setPassword("root");
                autoGenerator.setDataSource(dataSourceConfig);

                //包配置
                PackageConfig pc = new PackageConfig();
                //pc.setModuleName("module");
                pc.setParent("com.template");

                // 实体包名
                pc.setEntity("dao.domain");
                pc.setEntity("pojo.entity");

                // mapper 包名
                pc.setMapper("dao.mapper");
                pc.setMapper("dao");

                // mapper 对应映射器包名
                pc.setXml("dao.mapper.xml");
                pc.setXml("dao.xml");

                pc.setService("dao.service");
                pc.setServiceImpl("dao.service.impl");
                pc.setService("service.dao");
                pc.setServiceImpl("service.dao.impl");

            autoGenerator.setPackageInfo(pc);



            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
                strategy.setNaming(NamingStrategy.underline_to_camel);
                strategy.setColumnNaming(NamingStrategy.underline_to_camel);
                //        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
                strategy.setChainModel(true);
                strategy.setEntityLombokModel(true);
                strategy.setRestControllerStyle(true);

                // 忽略表前缀
                strategy.setTablePrefix(overlook_table_prefix);

            autoGenerator.setStrategy(strategy);

            // 循环生成表
            strategy.setInclude(tableName);

            //模板引擎配置
            TemplateConfig templateConfig = new TemplateConfig();
                //templateConfig.setService("");
                //templateConfig.setServiceImpl("");
//                templateConfig.setMapper("");
//                templateConfig.setController("");//设置为空不生成controller

                autoGenerator.setTemplate(templateConfig);
                autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

            autoGenerator.execute();
        }
    }
}

