package main;

import main.furniture.ArtDecoFactory;
import main.furniture.ModernFactory;
import main.furniture.VictorianFactory;

public class Main {
    public static void main(String[] args) {
        // Create main.Furniture Factories
        ArtDecoFactory artDecoFactory = new ArtDecoFactory();
        ModernFactory modernFactory = new ModernFactory();
        VictorianFactory victorianFactory = new VictorianFactory();

        // Create all types of chairs
        Furniture artDecoChair = artDecoFactory.getFurniture(FurnitureTypes.CHAIR);
        artDecoChair.build();

        Furniture modernChair = modernFactory.getFurniture(FurnitureTypes.CHAIR);
        modernChair.build();

        Furniture victorianChair = victorianFactory.getFurniture(FurnitureTypes.CHAIR);
        victorianChair.build();

        System.out.println(" "); // Blank line

        // Create all types of sofas
        Furniture artDecoSofa = artDecoFactory.getFurniture(FurnitureTypes.SOFA);
        artDecoSofa.build();

        Furniture modernSofa = modernFactory.getFurniture(FurnitureTypes.SOFA);
        modernSofa.build();

        Furniture victorianSofa = victorianFactory.getFurniture(FurnitureTypes.SOFA);
        victorianSofa.build();

        System.out.println(" "); // Blank Line

        // Create all types of coffee tables
        Furniture artDecoCoffeeTable = artDecoFactory.getFurniture(FurnitureTypes.COFFEE_TABLE);
        artDecoCoffeeTable.build();

        Furniture modernCoffeeTable = modernFactory.getFurniture(FurnitureTypes.COFFEE_TABLE);
        modernCoffeeTable.build();

        Furniture victorianCoffeeTable = victorianFactory.getFurniture(FurnitureTypes.COFFEE_TABLE);
        victorianCoffeeTable.build();
    }
}