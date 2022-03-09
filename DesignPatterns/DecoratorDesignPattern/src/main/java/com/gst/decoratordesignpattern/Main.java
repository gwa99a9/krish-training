/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gst.decoratordesignpattern;

/**
 *
 * @author OBITO
 */
public class Main {

    public static void main(String[] args) {
        Pizza p1 = new FishPizza();
        p1 = new BBQSauce(p1);
        p1 = new SwissCheese(p1);
        System.out.println(p1.getDescription() + " /= Rs." + p1.getPrice());

        Pizza p2 = new ChickenPizza();
        p2 = new BBQSauce(p2);
        p2 = new FriedOnions(p2);
        p2 = new Mayonnaise(p2);
        System.out.println(p2.getDescription() + " /= Rs." + p2.getPrice());

        Pizza p3 = new VeggiePizza();
        p3 = new SwissCheese(p3);
        p3 = new FriedOnions(p3);
        System.out.println(p3.getDescription() + " /= Rs." + p3.getPrice());
    }
}

abstract class Pizza {

    abstract public double getPrice();

    abstract public String getDescription();
}

class ChickenPizza extends Pizza {

    @Override
    public double getPrice() {
        return 850.0;
    }

    @Override
    public String getDescription() {
        return "Chicken Pizza";
    }
}

class VeggiePizza extends Pizza {

    @Override
    public double getPrice() {
        return 650.0;
    }

    @Override
    public String getDescription() {
        return "Veggie Pizza";
    }
}

class FishPizza extends Pizza {

    @Override
    public double getPrice() {
        return 720.0;
    }

    @Override
    public String getDescription() {
        return "Fish Pizza";
    }
}

abstract class PizzaDecorator extends Pizza {

    private final Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with ";
    }
}

class BBQSauce extends PizzaDecorator {

    public BBQSauce(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 50.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "BBQ Sauce";
    }
}

class SwissCheese extends PizzaDecorator {

    public SwissCheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 80.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Swiss Cheese";
    }
}

class FriedOnions extends PizzaDecorator {

    public FriedOnions(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 20.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Fried Onions";
    }
}

class Mayonnaise extends PizzaDecorator {

    public Mayonnaise(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 35.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Mayonnaise";
    }
}
