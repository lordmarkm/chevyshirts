package com.chevyshirts;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Mark Martinez, create Dec 21, 2015
 *
 */
@Configuration
@EnableJpaRepositories(basePackages={"com.chevyshirts..service"}, repositoryImplementationPostfix = "CustomImpl")
public class ServiceConfig {

}
