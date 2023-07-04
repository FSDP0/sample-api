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
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(value = "com.sample.testapi.mapper.master",
        sqlSessionFactoryRef = "masterSqlSessionFactory")
@EnableTransactionManagement
public class MasterDatabaseConfig {
    private final ApplicationContext applicationContext;

    public MasterDatabaseConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Primary
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "masterSqlSessionFactory")
    SqlSessionFactory masterSqlSessionFactory(
            @Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(masterDataSource);

        // application property yaml file 이외에도 해당 설정을 통해 각
        sqlSessionFactoryBean.setTypeAliasesPackage("com.sample.testapi.model");
        sqlSessionFactoryBean.setMapperLocations(
                this.applicationContext.getResources("classpath:mapper/master/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "masterSqlSessionTemplate")
    SqlSessionTemplate masterSessionTemplate(SqlSessionFactory masterSqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(masterSqlSessionFactory);
    }
}
