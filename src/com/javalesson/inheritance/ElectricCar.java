package com.javalesson.inheritance;

public class ElectricCar extends Auto{

    private int batteryVolume;
    private int passengersNumber;

    public ElectricCar(String producer, String model, int batteryVolume, int passengersNumber) {
        super(producer, model, new Engine());
        this.batteryVolume = batteryVolume;
        this.passengersNumber = passengersNumber;
    }

    private void charge(){
        System.out.println("Battery is charging");
    }

    public int getBatteryVolume() {
        return batteryVolume;
    }

    public void setBatteryVolume(int batteryVolume) {
        this.batteryVolume = batteryVolume;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    @Override
    public void energize() {
        charge();
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Car is starting");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);
        System.out.println("Car has stopped");
    }
}
