package Sensors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor{
    public ArrayList<Sensor> sensors;
    public ArrayList<Integer> readingList;

    public AverageSensor(){
        this.sensors = new ArrayList<>();
        this.readingList = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
        return sensors.stream()
                .filter(sensor -> !sensor.isOn()).collect(Collectors.toCollection(ArrayList::new))
                .size() == 0;
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
            throw new IllegalStateException("Sensors are off");
        }
        int sensorList = (int) sensors.stream().mapToInt(Sensor::read).average().getAsDouble();
        readingList.add(sensorList);
        return sensorList;
    }

    public void addSensor(Sensor toAdd){
        sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return readingList;
    }
}
