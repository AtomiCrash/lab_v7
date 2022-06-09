package com.example.labs.controller;

import com.example.labs.statistics.StatProvide;
import com.example.labs.statistics.Statistics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatController {
    private final StatProvide statsProvider;
    private StatProvide statProvide = new StatProvide();

    public StatController(StatProvide statsProvider) {
        this.statsProvider = statsProvider;
    }

    @GetMapping
    public ResponseEntity<Statistics> getAllStats() {
        statsProvider.calculate();
        return new ResponseEntity<>(statsProvider.getStats(), HttpStatus.OK);
    }
}