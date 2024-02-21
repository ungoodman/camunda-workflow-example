package com.github.ungoodman.camunda.workflow.starter.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@Slf4j
public class AppointmentWorker {
    @JobWorker(type = "appointment_job")
    public Map<String, Object> appointmentHandle(JobClient client, ActivatedJob job) {
        log.info("Incoming Job Type: {} | Instance ID: {}", job.getType(), job.getProcessInstanceKey());
        String isAvailable = new Random().nextBoolean() ? "Yes" : "No";
        Map<String, Object> map = new HashMap<>();
        map.put("isAvailable", isAvailable);
        log.info("Complete Job Type: {} | Instance ID: {} | isAvailable: {}", job.getType(), job.getProcessInstanceKey(), isAvailable);

        return map;
    }
}
