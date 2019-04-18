package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    Sensor sensor = new Sensor();

    boolean alarmOn = false;

    public Alarm(Sensor sensor) {
		super();
		this.sensor = sensor;
	}
    public Alarm() {
  		super();  	
  	}

	public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        checkAlarm(psiPressureValue);
    }

	void checkAlarm(double psiPressureValue) {
		if (psiPressureValue < LowPressureThreshold 
				|| HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
	}

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
