package com.codurance.lsp;

public abstract class Vehicle {

    private static final int FULL = 100;
    private int fuelTankLevel = 0;

    public void fillUpWithFuel(){
        this.fuelTankLevel = FULL;
    }

    public int fuelTankLevel() {
        return fuelTankLevel;
    }
}
