package com.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.example.dao.mapper.second"},sqlSessionFactoryRef = "sqlSessionFactory2")
public class SecondDatasourceConfig {

    @Bean("dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.datasource2")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }

    @Bean("sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource2());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/example/dao/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean("transactionManager2")
    public DataSourceTransactionManager transactionManager2(){
        return new DataSourceTransactionManager(dataSource2());
    }

    @Bean("sessionTemplate2")
    public SqlSessionTemplate sessionTemplate2() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory2());
    }
}
