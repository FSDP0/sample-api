package com.sample.testapi.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(value = "com.sample.testapi.mapper.slave",
        sqlSessionFactoryRef = "slaveSqlSessionFactory")
@EnableTransactionManagement
public class SlaveDatabaseConfig {
    private final ApplicationContext applicationContext;

    public SlaveDatabaseConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slaveSqlSessionFactory")
    SqlSessionFactory slaveSqlSessionFactory(
            @Qualifier("slaveDataSource") DataSource slaveDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(slaveDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.sample.testapi");
        sqlSessionFactoryBean.setMapperLocations(
                this.applicationContext.getResources("classpath:mapper/slave/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "slaveSqlSessionTemplate")
    SqlSessionTemplate slaveSqlSessionTemplate(SqlSessionFactory slaveSqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(slaveSqlSessionFactory);
    }
}
