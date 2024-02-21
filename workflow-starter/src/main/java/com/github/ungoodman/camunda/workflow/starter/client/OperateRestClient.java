package com.github.ungoodman.camunda.workflow.starter.client;

import com.github.ungoodman.camunda.workflow.starter.config.OperateAPIConfig;
import com.github.ungoodman.camunda.workflow.starter.model.ProcessInstanceSearchRequest;
import com.github.ungoodman.camunda.workflow.starter.model.ProcessInstanceSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OperateRestClient {
    private final OperateAPIConfig apiConfig;

    private final RestTemplate restTemplate;

    @Autowired
    public OperateRestClient(OperateAPIConfig apiConfig, RestTemplate restTemplate) {
        this.apiConfig = apiConfig;
        this.restTemplate = restTemplate;
    }

    public ProcessInstanceSearchResponse searchProcessInstance(ProcessInstanceSearchRequest request) {
        ResponseEntity<ProcessInstanceSearchResponse> responseEntity = restTemplate.exchange(apiConfig.getProcessInstanceSearch(),
                HttpMethod.POST, new HttpEntity<>(request), ProcessInstanceSearchResponse.class);

        return responseEntity.getBody();
    }
}
