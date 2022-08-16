package com.time.service;

import java.util.Date;
import java.util.TimeZone;

public interface ILocalTimeService {

    Date getLocalTime(String city);
}
