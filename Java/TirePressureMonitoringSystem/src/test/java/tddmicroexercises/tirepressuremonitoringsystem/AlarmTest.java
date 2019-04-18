package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
	Sensor sensor = Mockito.mock(Sensor.class);
	Alarm alarm = new Alarm(sensor);
	
	@Test
	public void testCheckAlarm() throws Exception {
		Alarm alarm = new Alarm();
		alarm.checkAlarm(0.0);
		
		Assert.assertTrue(alarm.alarmOn);
	}
	
	@Test
	public void testCheckAlarm1() throws Exception {
		Alarm alarm = new Alarm();
		alarm.checkAlarm(42);
		
		Assert.assertTrue(alarm.alarmOn);
	}
	
	@Test
	public void testCheckAlarm2() throws Exception {
		Alarm alarm = new Alarm();
		alarm.checkAlarm(20);
		
		Assert.assertFalse(alarm.alarmOn);
	}
	
	@Test
	public void testCheckAlarm3() throws Exception {
		Alarm alarm = new Alarm();
		alarm.checkAlarm(17);
		
		Assert.assertFalse(alarm.alarmOn);
	}
	
	@Test
	public void testCheckAlarm4() throws Exception {
		Alarm alarm = new Alarm();
		alarm.checkAlarm(16.9);
		
		Assert.assertTrue(alarm.alarmOn);
	}
	
	@Test
	public void testCheckAlarm5() throws Exception {
		Alarm alarm = new Alarm();
		alarm.checkAlarm(17.1);
		
		Assert.assertFalse(alarm.alarmOn);
	}

	@Test
	public void testCheckAlarm6() throws Exception {
		Alarm alarm = new Alarm();
		alarm.checkAlarm(21);
		
		Assert.assertFalse(alarm.alarmOn);
	}

	
	@Test
	public void testCheckAlarm7() throws Exception {
		Alarm alarm = new Alarm();
		alarm.checkAlarm(21.1);
		
		Assert.assertTrue(alarm.alarmOn);
	}

	@Test
	public void testCheck() throws Exception {
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.0);
		alarm.check();
		Assert.assertFalse(alarm.alarmOn);
	}
	
	@Test
	public void testCheck2() throws Exception {
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.1);
		alarm.check();
		Assert.assertTrue(alarm.alarmOn);
	}
	
	@Test
	public void testCheck3() throws Exception {
		Sensor sensor = new Sensor();
		sensor = Mockito.mock(Sensor.class);
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.9);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		Assert.assertTrue(alarm.alarmOn);
	}
	
	@Test
	public void testCheck4() throws Exception {
		Sensor sensor = new Sensor();
		sensor = Mockito.mock(Sensor.class);
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(17.1);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		Assert.assertFalse(alarm.alarmOn);
	}
	
	@Test
	public void testCheck5() throws Exception {
		Sensor sensor = new Sensor();
		sensor = Mockito.mock(Sensor.class);
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(17.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		Assert.assertFalse(alarm.alarmOn);
	}

}
