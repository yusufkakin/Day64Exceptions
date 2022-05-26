package Sensors;

public class StandardSensor implements Sensor{
    public int theInput;

    public StandardSensor(int theInput){
        this.theInput = theInput;
    }
    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {

    }

    @Override
    public void setOff() {

    }

    @Override
    public int read() {
        return this.theInput;
    }
}
