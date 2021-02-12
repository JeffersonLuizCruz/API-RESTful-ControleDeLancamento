package com.lacamento.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Profile("oauth-security")
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig {

}
