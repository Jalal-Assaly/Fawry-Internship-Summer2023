package main.classes;

import main.Furniture;

public class ModernChair implements Furniture {
    @Override
    public void build(){
        System.out.println("You built a Modern Chair");
    }
}
