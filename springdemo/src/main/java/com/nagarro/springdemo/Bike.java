package com.nagarro.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

    public void drive() {
        System.out.println("chal raha hai......");
    }
}
