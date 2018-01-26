package com.codurance.lsp;

public class ElectricCar extends Vehicle{

    @Override
    public void fillUpWithFuel() {
        throw new UnsupportedOperationException("It's an electric car");
    }
}
