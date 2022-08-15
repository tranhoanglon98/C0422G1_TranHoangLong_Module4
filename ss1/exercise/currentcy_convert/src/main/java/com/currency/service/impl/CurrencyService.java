package com.currency.service.impl;

import com.currency.service.ICurrencyService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService implements ICurrencyService {

    @Override
    public Map<String, String> validate(String amount, String from) {
        Map<String, String> errMap = new HashMap<>();

        if (!amount.isEmpty()) {
            try {
                if (Double.parseDouble(amount) < 0) {
                    errMap.put("amountErr", "amount of money must be positive");
                }
            } catch (NumberFormatException e) {
                errMap.put("amountErr", "Please input right format");
            }
        } else {
            errMap.put("amountErr", "Please input amount of money");
        }
        return errMap;
    }

    @Override
    public double convertCurrency(String amount, String from) {
        Map<String, String> errMap = this.validate(amount, from);

        double result = 0;
        if (errMap.isEmpty()) {
            switch (from) {
                case "USD":
                    result = Double.parseDouble(amount) * 23000;;
                    break;
                case "VND":
                    result = Double.parseDouble(amount) / 23000;
                    break;
            }
        }
        return result;
    }
}