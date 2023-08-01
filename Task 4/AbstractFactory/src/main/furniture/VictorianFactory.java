package main.furniture;
import main.*;
import main.abstract_factory.AbstractFactory;
import main.classes.VictorianChair;
import main.classes.VictorianCoffeeTable;
import main.classes.VictorianSofa;

public class VictorianFactory extends AbstractFactory {
    @Override
    public Furniture getFurniture(FurnitureTypes furnitureTypes){
        switch (furnitureTypes){
            case CHAIR -> { return new VictorianChair(); }
            case SOFA -> { return new VictorianSofa(); }
            case COFFEE_TABLE -> { return new VictorianCoffeeTable(); }
            default -> { return null; }
        }
    }
}
