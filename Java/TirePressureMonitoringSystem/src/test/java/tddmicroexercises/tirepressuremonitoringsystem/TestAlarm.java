package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.*;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class TestAlarm {

    Alarm alarm = new Alarm();
    
    // alternative 1 open a back door

    @Test
    public void alarmIsOffToStartWith() {
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void alarmIsOnBelow17() {
        assertTrue(getAlarmStatusFor(16));
        assertTrue(getAlarmStatusFor(15));
        assertTrue(getAlarmStatusFor(0));
    }

    @Test
    public void alarmIsOnAbove22() {
        assertTrue(getAlarmStatusFor(22));
        assertTrue(getAlarmStatusFor(23));
        assertTrue(getAlarmStatusFor(30));
    }

    @Test
    public void alarmIsOffInBetween() {
        assertFalse(getAlarmStatusFor(17));
        assertFalse(getAlarmStatusFor(18));
        assertFalse(getAlarmStatusFor(19));
        assertFalse(getAlarmStatusFor(20));
        assertFalse(getAlarmStatusFor(21));
    }
    
    
    // Or better yet inject a sensor


    @Test
    public void alarmIsOnBelow17_alternative() {
        assertTrue(getAlarmStatusWithStub(16));
        /// etc ...
    }

    private boolean getAlarmStatusWithStub(double psiValue) {
        Sensor sensorStub = mock(Sensor.class);
        Mockito.when(sensorStub.popNextPressurePsiValue()).thenReturn(psiValue);
        Alarm alarm = new Alarm(sensorStub);
        alarm.check();
        return alarm.isAlarmOn();
    }

    private boolean getAlarmStatusFor(int psiPressureValue) {
        alarm.check(psiPressureValue);

        return alarm.isAlarmOn();
    }
}
