package com.example.demo.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceHello {
    private final Counter counter;
    private final Timer timer;
    private Counter inputSizeMetric;

    Counter outputSizeMetric;

    public ServiceHello(@Qualifier("method_call_count") Counter counter, @Qualifier("method_execution_timer") Timer timer) {
        this.counter = counter;
        this.timer = timer;
    }


    public String hel(String s) {
        Timer.Sample sample = Timer.start();
        inputSizeMetric.increment(s.length());
        try {

            return "Hello!!!";
        } finally {
            counter.increment();
            sample.stop(timer);
        }
    }


}
