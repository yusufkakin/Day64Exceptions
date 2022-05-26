package Sensors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor{
    public ArrayList<Sensor> sensors;
    private ArrayList<Integer> readingList;

    public AverageSensor(){
        this.sensors = new ArrayList<>();
        this.readingList = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
        if(sensors.stream()
                .filter(sensor -> !sensor.isOn()).collect(Collectors.toCollection(ArrayList::new))
                .size()!=0){
            return false;
        }
        return true;
    }

    @Override
    public void setOn() {
        sensors
                .stream()
                .forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensors
        .stream()
        .forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if(!isOn()) {
            throw new IllegalStateException("Warning: attempt to read while "
                    + "one or mre sensors are off");
        }
        int j = (int) sensors.stream().mapToInt(Sensor::read).average().getAsDouble();
        readingList.add(j);
        return j;
    }

    public void addSensor(Sensor toAdd){
        sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return readingList;
    }
}
