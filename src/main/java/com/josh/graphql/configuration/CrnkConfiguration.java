// Copyright (c) 2019 Travelex Ltd

package com.josh.graphql.configuration;

import io.crnk.security.ResourcePermission;
import io.crnk.security.SecurityConfig;
import io.crnk.security.SecurityModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrnkConfiguration {

    /**
     * Crnk security authorization config.
     *
     * @return the module.
     */
    @Bean
    public SecurityModule securityModule() {
        SecurityConfig.Builder builder = SecurityConfig.builder();
        builder.permitAll(ResourcePermission.ALL);
        return SecurityModule.newServerModule(builder.build());
    }

}
