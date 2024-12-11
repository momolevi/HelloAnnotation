package com.kuang.annotation;

import java.util.Arrays;

public class Test04 {
    public static void main(String[] args) throws NoSuchFieldException {
        BMW bmw = new BMW();
        System.out.println(Arrays.toString(BMW.class.getDeclaredMethods()));
        System.out.println(Arrays.toString(BMW.class.getDeclaredFields()));
        System.out.println(Arrays.toString(BMW.class.getFields()));
    }

}


class Car{
    private String wheels;
    public String brand;
    private String seat;

    public Car() {
    }

    public Car(String wheels, String brand, String seat) {
        this.wheels = wheels;
        this.brand = brand;
        this.seat = seat;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}

class BMW extends Car{
    private int id;
    public int og;
    Car bmw = new Car("2","BMW","2");
}

class Benz extends Car{
    private int id;
    public int og;
    Car benz = new Car("4", "Benz", "5");
}