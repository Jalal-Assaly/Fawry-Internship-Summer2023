package main.classes;

import main.Furniture;

public class ModernCoffeeTable implements Furniture {
    @Override
    public void build(){
        System.out.println("You built a Modern Coffee Table");
    }
}
