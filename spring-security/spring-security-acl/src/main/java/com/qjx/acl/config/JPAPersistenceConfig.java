package com.qjx.acl.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by qincasin on 2020/7/12.
 */
@Configurable
@EnableTransactionManagement
@EnableJpaRepositories(basePackages ="com.qjx.acl.persistence.dao" )
@PropertySource("classpath:com.qjx.acl.datasource.properties")
@EntityScan(basePackages={ "com.qjx.acl.persistence.entity" })
public class JPAPersistenceConfig {
}
