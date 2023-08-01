package main.classes;

import main.Furniture;

public class ArtDecoCoffeeTable implements Furniture {
    @Override
    public void build(){
        System.out.println("You built an Art Deco Coffee Table");
    }
}
