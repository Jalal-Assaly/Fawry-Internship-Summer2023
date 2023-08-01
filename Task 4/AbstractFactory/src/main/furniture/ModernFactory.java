package main.furniture;
import main.*;
import main.abstract_factory.AbstractFactory;
import main.classes.ModernChair;
import main.classes.ModernCoffeeTable;
import main.classes.ModernSofa;

public class ModernFactory extends AbstractFactory {
    @Override
    public Furniture getFurniture(FurnitureTypes furnitureTypes){
        switch (furnitureTypes){
            case CHAIR -> { return new ModernChair(); }
            case SOFA -> { return new ModernSofa(); }
            case COFFEE_TABLE -> { return new ModernCoffeeTable(); }
            default -> { return null; }
        }
    }
}
