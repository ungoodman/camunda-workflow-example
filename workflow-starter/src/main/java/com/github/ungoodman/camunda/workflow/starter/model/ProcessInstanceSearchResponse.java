package com.github.ungoodman.camunda.workflow.starter.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ProcessInstanceSearchResponse {
    List<ProcessInstance> items;
    List<Objects> sortValues;
    Integer total;
}
