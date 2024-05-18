package ru.vsu.putinpa.simplecode.model;

import lombok.Data;

@Data
public class RunResult {
    private int outcome;
    private String cmpinfo;
    private String stdout;
    private String stderr;
}
