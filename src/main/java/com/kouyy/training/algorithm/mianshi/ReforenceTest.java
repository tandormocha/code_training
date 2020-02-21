package com.kouyy.training.algorithm.mianshi;

import java.lang.ref.WeakReference;

public class ReforenceTest {
    public static void main(String[] args)
    {
        Car car = new Car(2000.0, "red");
        WeakReferenceCar wrc = new WeakReferenceCar(car);
//        wrc.setStr("111");
        int i = 0;
        while (true)
        {
            if (wrc.get() != null)
            {
                i++;
                System.out.println("WeakReferenceCar's Car is alive for " + i + ", loop - " + wrc);
            }
            else
            {
                System.out.println("WeakReferenceCar's Car has bean collected");
                break;
            }
        }
    }
}


class Car {
    private double     price;
    private String    color;

    public Car(double price, String color)
    {
        this.price = price;
        this.color = color;
    }

    public double getPrice()
    {
        return price;
    }

    public String getColor()
    {
        return color;
    }

    @Override
    public String toString()
    {
        return "This car is a " + this.color + " car, costs $" + price;
    }
}

class WeakReferenceCar extends WeakReference<Car> {
    public WeakReferenceCar(Car car) {
        super(car);
    }

}


