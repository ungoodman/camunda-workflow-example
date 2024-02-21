package com.github.ungoodman.camunda.workflow.starter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class ProcessInstanceSearchRequest {
    ProcessInstance filter;
    Integer size;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    List<ProcessInstanceSort> sort;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    List<ProcessInstanceSort> searchAfter;
}
