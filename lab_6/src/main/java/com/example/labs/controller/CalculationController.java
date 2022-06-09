package com.example.labs.controller;

import com.example.labs.cache.Cache;
import com.example.labs.calculations.Parametres;
import com.example.labs.calculations.Solution;
import com.example.labs.calculations.StreamLogic;
import com.example.labs.exceptions.BadRequestException;
import com.example.labs.logger.ProgramLogger;
import org.apache.logging.log4j.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@RestController
public class CalculationController {
    Counter callsCounter = new Counter();
    void Validation(Integer a, Integer b, Integer option) {

        String error = "";
        if (a < 0 || b < 0) {
            throw new BadRequestException("Wrong data! Parameter A and B");
        }
        if (a < 0) {
            throw new BadRequestException("Wrong data! Parameter A");
        }
        if (b < 0) {
            throw new BadRequestException("Wrong data! Parameter B");
        }
        if (!(option==0 || (option==1))) {
            throw new BadRequestException("Wrong data! Parameter Operation");
        }
    }

    public ResponseEntity<Object> calc(@RequestParam(value = "a", defaultValue = "1") Integer a,
                                       @RequestParam(value = "b", defaultValue = "3") Integer b,
                                       @RequestParam(value = "operation", defaultValue = "0") Integer operation) throws BadRequestException {



        Validation(a, b, operation);
        callsCounter.countCalls();
        var solution = new Solution(new Parametres(a, b, operation));

        solution.calculateRoot();


        return new ResponseEntity<>(solution.getRoot(), HttpStatus.OK);
    }

    @GetMapping(value = "/cache")
    public ResponseEntity<String> printCache() {
        return new ResponseEntity<>(Cache.getStaticStringCache(), HttpStatus.OK);
    }

    @PostMapping(value = "/inputStream")
    public ResponseEntity filter(@RequestBody String[] arr) {
        ProgramLogger.log(Level.INFO, "input reached");
        StreamLogic streamLogic = new StreamLogic();
        return new ResponseEntity<>(streamLogic.calculateSum(arr),HttpStatus.OK);
    }

}
