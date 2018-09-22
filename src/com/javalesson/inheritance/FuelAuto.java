package com.javalesson.inheritance;


public abstract class FuelAuto extends Auto {

    private int availablePetrol;
    private int tankVolume;

    public FuelAuto(String producer, String model, Engine engine, int availablePetrol, int tankVolume) {
        super(producer, model, engine);
        this.availablePetrol = availablePetrol;
        this.tankVolume = tankVolume;
    }

    void fuelUp(int petrolVolume){
        availablePetrol+=petrolVolume;
        System.out.println("Adding fuel");
    }



    public int getAvailablePetrol() {
        return availablePetrol;
    }

    public void setAvailablePetrol(int availablePetrol) {
        this.availablePetrol = availablePetrol;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }
}
