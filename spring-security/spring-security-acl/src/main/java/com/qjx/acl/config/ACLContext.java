package com.qjx.acl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.acls.AclPermissionCacheOptimizer;
import org.springframework.security.acls.AclPermissionEvaluator;
import org.springframework.security.acls.domain.*;
import org.springframework.security.acls.jdbc.BasicLookupStrategy;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.acls.jdbc.LookupStrategy;
import org.springframework.security.acls.model.PermissionGrantingStrategy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.sql.DataSource;

/**
 * Created by qincasin on 2020/7/12.
 */
@Configurable
@EnableAutoConfiguration
public class ACLContext {

    @Autowired
    private DataSource dataSource;

    @Bean
    public EhCacheBasedAclCache aclCache(){
        return new EhCacheBasedAclCache(aclEhCacheBasedAclCache().getObject(),permissionGrantingStrategy(),aclAuthorizationStrategy());
    }

    @Bean
    public EhCacheFactoryBean aclEhCacheBasedAclCache(){
        EhCacheFactoryBean factoryBean = new EhCacheFactoryBean();
        factoryBean.setCacheManager(aclCacheManager().getObject());
        factoryBean.setCacheName("aclCache");
        return factoryBean;
    }

    @Bean
    public EhCacheManagerFactoryBean aclCacheManager(){
        return new EhCacheManagerFactoryBean();
    }

    @Bean
    public PermissionGrantingStrategy permissionGrantingStrategy (){
        return new DefaultPermissionGrantingStrategy(new ConsoleAuditLogger());
    }

    @Bean
    public AclAuthorizationStrategy aclAuthorizationStrategy(){
        return new AclAuthorizationStrategyImpl(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Bean
    public MethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler(){
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        AclPermissionEvaluator permissionEvaluator = new AclPermissionEvaluator(aclService());
        expressionHandler.setPermissionEvaluator(permissionEvaluator);
        expressionHandler.setPermissionCacheOptimizer(new AclPermissionCacheOptimizer(aclService()));
        return expressionHandler;
    }

    @Bean
    public LookupStrategy lookupStrategy(){
        return new BasicLookupStrategy(dataSource,aclCache(),aclAuthorizationStrategy(),new ConsoleAuditLogger());
    }

    @Bean
    public JdbcMutableAclService aclService(){
        return new JdbcMutableAclService(dataSource, lookupStrategy(), aclCache());
    }

}
