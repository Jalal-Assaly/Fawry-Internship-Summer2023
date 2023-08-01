package main.classes;

import main.Furniture;

public class ModernSofa implements Furniture {
    @Override
    public void build(){
        System.out.println("You built a Modern Sofa");
    }
}
