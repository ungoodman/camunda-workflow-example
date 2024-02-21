package com.github.ungoodman.camunda.workflow.starter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProcessInstance {
    Long key;
    Integer processVersion;

    @NonNull
    String bpmnProcessId;

    LocalDateTime startDate;
    LocalDateTime endDate;
    String state;
    Long processDefinitionKey;
    String tenantId;
}
