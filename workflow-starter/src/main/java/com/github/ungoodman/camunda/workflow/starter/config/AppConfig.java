package com.github.ungoodman.camunda.workflow.starter.config;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public ZeebeClient zeebeClient(ZeebeConfig config) {
////        OAuthCredentialsProvider credentialsProvider =
////                new OAuthCredentialsProviderBuilder()
////                        .authorizationServerUrl(config.getOAuthApi())
////                        .audience(config.getAudience())
////                        .clientId(config.getClientId())
////                        .clientSecret(config.getClientSecret())
////                        .build();
//
//        ZeebeClient client = ZeebeClient.newClientBuilder()
//                .gatewayAddress(config.getZeebeApi())
////                .credentialsProvider(credentialsProvider)
//                .usePlaintext()
//                .build();
//
//        client.newTopologyRequest().send().join();
//
//        return client;
//    }
}
