package ru.vsu.putinpa.simplecode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.putinpa.simplecode.model.TaskRun;
import ru.vsu.putinpa.simplecode.service.JobeInABoxService;


@CrossOrigin
@RestController
@RequiredArgsConstructor
public class TasksRpcController {

    private final JobeInABoxService jobeService;

    @PostMapping("/runs")
    public ResponseEntity<?> submitRun(@RequestBody TaskRun taskRun) {
        jobeService.runs(taskRun);
        return ResponseEntity.ok("working");
    }
}