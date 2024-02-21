package com.github.ungoodman.camunda.workflow.starter.controller;

import com.github.ungoodman.camunda.workflow.starter.model.ProcessInstance;
import com.github.ungoodman.camunda.workflow.starter.model.ProcessInstanceSearchRequest;
import com.github.ungoodman.camunda.workflow.starter.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/workflow")
public class WorkflowController {
    @Autowired
    private WorkflowService service;

    @PostMapping
    public ResponseEntity<List<ProcessInstance>> getWorkflowList(
            @RequestBody ProcessInstanceSearchRequest request) {
        return new ResponseEntity<>(service.getTasklist(request), HttpStatus.OK);
    }

    @GetMapping("/start")
    public ResponseEntity<String> startWorkflow(@RequestParam("processId") String processId) {
        return new ResponseEntity<>(service.startWorkflow(processId), HttpStatus.CREATED);
    }
}
