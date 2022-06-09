package com.example.labs.statistics;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Statistics {
    protected Long totalRequests = 0L;
    protected Long wrongRequests = 0L;

    protected Integer min = 0;

    protected Integer max = 0;

    protected Integer mostCommon = 0;
}
