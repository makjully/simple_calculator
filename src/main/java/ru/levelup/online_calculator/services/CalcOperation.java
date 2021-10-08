package ru.levelup.online_calculator.services;

import org.springframework.stereotype.Service;

@Service
public class CalcOperation {

    public double sum(double a, double b) {
        return a + b;
    }

    public double subtr(double a, double b) {
        return a - b;
    }

    public double multipl(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        return a / b;
    }
}