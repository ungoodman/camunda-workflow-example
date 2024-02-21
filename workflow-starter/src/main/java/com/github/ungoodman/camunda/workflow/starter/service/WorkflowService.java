package com.github.ungoodman.camunda.workflow.starter.service;

import com.github.ungoodman.camunda.workflow.starter.client.OperateRestClient;
import com.github.ungoodman.camunda.workflow.starter.model.ProcessInstance;
import com.github.ungoodman.camunda.workflow.starter.model.ProcessInstanceSearchRequest;
import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowService {
    private final ZeebeClient zeebeClient;
    private final OperateRestClient operateRestClient;

    @Autowired
    public WorkflowService(ZeebeClient zeebeClient, OperateRestClient operateRestClient) {
        this.zeebeClient = zeebeClient;
        this.operateRestClient = operateRestClient;
    }

    public String startWorkflow(String processId) {
        ProcessInstanceEvent result = zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(processId)
                .latestVersion()
                .send()
                .join();

        return String.valueOf(result.getProcessInstanceKey());
    }

    public List<ProcessInstance> getTasklist(ProcessInstanceSearchRequest request) {
        return operateRestClient.searchProcessInstance(request).getItems();
    }
}
