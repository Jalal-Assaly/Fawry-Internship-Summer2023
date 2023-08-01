package main.classes;

import main.Furniture;

public class ArtDecoSofa implements Furniture {
    @Override
    public void build(){
        System.out.println("You built an Art Deco Sofa");
    }
}
