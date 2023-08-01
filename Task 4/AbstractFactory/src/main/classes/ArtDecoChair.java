package main.classes;

import main.Furniture;

public class ArtDecoChair implements Furniture {
    @Override
    public void build(){
        System.out.println("You built an Art Deco Chair");
    }
}
