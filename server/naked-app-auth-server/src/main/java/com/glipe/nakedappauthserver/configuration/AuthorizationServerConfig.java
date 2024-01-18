package com.glipe.nakedappauthserver.configuration;

import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

@Configuration
@Import(OAuth2AuthorizationServerAutoConfiguration.class)
public class AuthorizationServerConfig {


    @Bean
    public RegisteredClientRepository
}
