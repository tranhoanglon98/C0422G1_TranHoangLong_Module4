package com.calculator.service.impl;

import com.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String calculate(double number1, double number2, String operator) {
        String result = "";
        switch (operator) {
            case "add":
                result = String.valueOf(number1 + number1);
                break;
            case "sub":
                result = String.valueOf(number1 - number2);
                break;
            case "mul":
                result = String.valueOf(number1 * number2);
                break;
            case "div":
                if (number2 == 0) {
                    result = "Can't divide by zero";
                } else {
                    result = String.valueOf(number1 / number2);
                }
                break;
        }
        return result;
    }
}
