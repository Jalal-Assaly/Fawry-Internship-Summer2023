package main.abstract_factory;

import main.Furniture;
import main.FurnitureTypes;

public abstract class AbstractFactory {
    public abstract Furniture getFurniture(FurnitureTypes furnitureTypes);
}
