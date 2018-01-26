package com.codurance.isp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class DogShould {
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    private final Dog dog = new Dog();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(consoleContent));
    }


    @Test
    void run() {
        dog.run();
        assertThat(consoleContent.toString())
                .isEqualTo("Dog is running");
    }

    @Test
    void bark() {
        dog.bark();
        assertThat(consoleContent.toString())
                .isEqualTo("Dog is barking");
    }
}