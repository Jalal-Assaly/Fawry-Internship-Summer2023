package main.classes;

import main.Furniture;

public class VictorianChair implements Furniture {
    @Override
    public void build(){
        System.out.println("You built a Victorian Chair");
    }
}
