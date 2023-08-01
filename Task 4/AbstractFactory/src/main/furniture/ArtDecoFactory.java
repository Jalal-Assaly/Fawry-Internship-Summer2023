package main.furniture;

import main.*;
import main.abstract_factory.AbstractFactory;
import main.classes.ArtDecoChair;
import main.classes.ArtDecoCoffeeTable;
import main.classes.ArtDecoSofa;

public class ArtDecoFactory extends AbstractFactory {

    @Override
    public Furniture getFurniture(FurnitureTypes furnitureTypes){
        switch (furnitureTypes){
            case CHAIR -> { return new ArtDecoChair(); }
            case SOFA -> { return new ArtDecoSofa(); }
            case COFFEE_TABLE -> { return new ArtDecoCoffeeTable(); }
            default -> { return null; }
        }
    }
}
