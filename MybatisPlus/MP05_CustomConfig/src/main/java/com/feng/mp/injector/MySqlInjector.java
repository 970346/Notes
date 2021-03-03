package com.feng.mp.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * 自定义全局操作
 */
public class MySqlInjector extends AutoSqlInjector {
    /**
     * 扩展inject方法
     */
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        //将EmployeeMapper中定义的deleteAll。处理成对应的MapperStatement独享，加入到configuration对象中
        //需要注入的sql语句
        String sql = "delete from "+table.getTableName();
        //需要注入的方法名   一定要与EmployeeMapper中的方法一致
        String method = "deleteAll";
        //构造SqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration,sql,modelClass);
        //构造一个删除的MappedStatment
        this.addDeleteMappedStatement(mapperClass,method,sqlSource);

    }
}
