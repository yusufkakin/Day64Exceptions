package Sensors;

import java.util.Random;

public class TemperatureSensor implements Sensor{

    public boolean isOn;
    static int temperature;

    public TemperatureSensor(){
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void setOn() {
        isOn = true;
    }

    @Override
    public void setOff() {
        isOn = false;
    }

    @Override
    public int read() {
        if(this.isOn()){
            return temperature = new Random().nextInt(61)-30;
        } else
            throw new IllegalArgumentException("Sensor is off");

    }
}
