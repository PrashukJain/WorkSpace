package com.nagarro.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {
    public void drive() {
        System.out.println("Bhaag raha hai......");
    }
}
