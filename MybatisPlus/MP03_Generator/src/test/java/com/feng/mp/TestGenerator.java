package com.feng.mp;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class TestGenerator {
    /**
     * 代码生成
     */
    @Test
    public void Test(){
        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)            //开启AR模式
              .setAuthor("feng")                //作者
              .setOutputDir("E:\\学习案例\\MybatisPlus\\MP03_Generator\\src\\main\\java")             //生成路径
              .setFileOverride(true)            //文件覆盖
              .setIdType(IdType.AUTO)           //主键策略
              .setServiceName("%sService")      //设置生成service接口的名字的首字母是否为I
              .setBaseResultMap(true)
              .setBaseColumnList(true);
        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)        //设置数据类型
                        .setDriverName("com.mysql.jdbc.Driver")
                        .setUrl("jdbc:mysql://localhost:3306/mp")
                        .setUsername("root")
                        .setPassword("123456");
        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)             //全局大写命名
                      .setDbColumnUnderline(true)       //指定表明 字段名是否下划线
                      .setNaming(NamingStrategy.underline_to_camel)     //数据库表映射到实体的命名策略
                      .setInclude("tbl_employee");      //生成表
        //4.包名策略
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.feng.mp")
                     .setMapper("mapper")
                     .setService("service")
                     .setController("controller")
                     .setEntity("beans");
        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        autoGenerator.execute();
    }
}
