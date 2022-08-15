package com.currency.service;

import java.util.Map;

public interface ICurrencyService {
    Map<String, String> validate(String amount, String from);

    double convertCurrency(String amount,String from);
}
