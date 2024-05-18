package ru.vsu.putinpa.simplecode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import ru.vsu.putinpa.simplecode.model.TaskRun;
import ru.vsu.putinpa.simplecode.service.JobeInABoxService;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
@RequiredArgsConstructor
public class TasksRpcController {

    private final JobeInABoxService jobeService;

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @PostMapping("/runs")
    public ResponseEntity<?> submitRun(@RequestBody TaskRun taskRun) {
        System.out.println(taskRun);
        return ResponseEntity.ok(null);
    }
}
