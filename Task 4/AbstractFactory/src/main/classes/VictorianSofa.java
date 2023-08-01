package main.classes;

import main.Furniture;

public class VictorianSofa implements Furniture {
    @Override
    public void build(){
        System.out.println("You built an Victorian Sofa");
    }
}
