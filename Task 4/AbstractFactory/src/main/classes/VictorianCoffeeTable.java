package main.classes;

import main.Furniture;

public class VictorianCoffeeTable implements Furniture {
    @Override
    public void build(){
        System.out.println("You built a Victorian Coffee Table");
    }
}
