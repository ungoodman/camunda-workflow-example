package com.github.ungoodman.camunda.workflow.starter.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "operate-api")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperateAPIConfig {
    String processInstanceSearch;
}
