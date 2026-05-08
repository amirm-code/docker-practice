package com.demo.docker_practice.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greet(String name){
        return "HELLO " + name + " - géré par un bean Spring";
    }
}
