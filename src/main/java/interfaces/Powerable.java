package interfaces;

import exceptions.MonitorAlreadyOffException;
import exceptions.MonitorAlreadyOnException;

// Used in devices.Desktop
public interface Powerable {
    void powerOn() throws MonitorAlreadyOnException;
    void powerOff() throws MonitorAlreadyOffException;
}
