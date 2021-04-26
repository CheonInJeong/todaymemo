package com.cafe24.todaymemo.config;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@MapperScan(value = "com.cafe24.todaymemo.dao",sqlSessionFactoryRef = "mybatisSqlSessionFactory")
@EnableTransactionManagement
public class MybatisConfig {


	   
	   @Bean(name = "mybatisSqlSessionFactory")
	   public SqlSessionFactory mybatisSqlSessionFactory(DataSource dataSource,
	                                         ApplicationContext context) throws Exception {
	      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	      sqlSessionFactoryBean.setDataSource(dataSource);
	      sqlSessionFactoryBean.setMapperLocations(context.getResources("classpath:mapper/**/*.xml"));
	      sqlSessionFactoryBean.setTypeAliasesPackage("com.cafe24.todaymemo.dto");   
	      return sqlSessionFactoryBean.getObject();
	   }
	   @Bean(name = "mybatisSqlSessionTemplate")
	   public SqlSessionTemplate mybatisSqlSessionTemplate(
	         @Qualifier("mybatisSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {      
	      return new SqlSessionTemplate(sqlSessionFactory);
	   }
	   @Bean(name = "mybatisTransactionManager")
	   public PlatformTransactionManager transactionManager(DataSource dataSource) {
	      return new DataSourceTransactionManager(dataSource);
	   }

}
