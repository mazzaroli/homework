package com.solvd.interfaces;

import com.solvd.exceptions.MonitorAlreadyOffException;
import com.solvd.exceptions.MonitorAlreadyOnException;

// Used in com.solvd.devices.Desktop
public interface Powerable {
    void powerOn() throws MonitorAlreadyOnException;
    void powerOff() throws MonitorAlreadyOffException;
}
