package com.example.demo.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceHello {
    @Qualifier("method_call_count")
    @Autowired
    private Counter counter;
    @Qualifier("method_execution_timer")
    @Autowired
    private Timer timer;
    // Создание счетчика для размера входных данных
    private Counter inputSizeMetric;

    // Создание счетчика для размера выходных данных
    Counter outputSizeMetric;


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
