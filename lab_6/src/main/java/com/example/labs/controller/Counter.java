package com.example.labs.controller;

import com.example.labs.logger.ProgramLogger;
import org.apache.logging.log4j.Level;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Counter {
    static int callAmount = 0;
    void Counter(){this.callAmount = 0;}
    synchronized public void countCalls() {
        callAmount++;
        ProgramLogger.log(Level.INFO, "Counter has been increased.");
    }

    @GetMapping("/calls")
    synchronized public int outputAmount() {
        ProgramLogger.log(Level.INFO, "Calls mapping have been successfully done");
        return callAmount;
    }
}

