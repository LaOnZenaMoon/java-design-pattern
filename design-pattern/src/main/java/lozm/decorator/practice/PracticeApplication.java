package lozm.decorator.practice;

import lozm.decorator.practice.code.Coffee;
import lozm.decorator.practice.code.CoffeeOptions;
import lozm.decorator.practice.code.CoffeeSize;
import lozm.decorator.practice.code.Condition;
import lozm.decorator.practice.coffee.*;
import lozm.decorator.practice.condition.Hot;
import lozm.decorator.practice.condition.Ice;
import lozm.decorator.practice.options.Mocha;
import lozm.decorator.practice.options.Soy;
import lozm.decorator.practice.options.Whip;
import lozm.decorator.practice.size.Large;
import lozm.decorator.practice.size.Medium;
import lozm.decorator.practice.size.Small;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Component coffee = null;
        while (true) {
            System.out.println("Which coffee do you offer?");
            System.out.println("- Americano");
            System.out.println("- Latte");
            System.out.println("- Cold brew");
            System.out.println("- Espresso");
            System.out.println("- Cappuccino");
            String input = scanner.nextLine().toUpperCase();

            Coffee[] coffees = Coffee.values();
            boolean isCoffee = Arrays.stream(coffees).anyMatch((element -> String.valueOf(element).equals(input)));
            if (isCoffee) {
                if (input.equals(String.valueOf(Coffee.AMERICANO))) {
                    coffee = new Americano();
                } else if (input.equals(String.valueOf(Coffee.LATTE))) {
                    coffee = new Latte();
                } else if (input.equals(String.valueOf(Coffee.COLD_BREW))) {
                    coffee = new ColdBrew();
                } else if (input.equals(String.valueOf(Coffee.ESPRESSO))) {
                    coffee = new Espresso();
                } else if (input.equals(String.valueOf(Coffee.CAPPUCCINO))) {
                    coffee = new Cappuccino();
                }

                break;
            }
        }

        while (true) {
            System.out.println("Which condition do you offer?");
            System.out.println("- Ice");
            System.out.println("- Hot");
            String input = scanner.nextLine().toUpperCase();

            Condition[] conditions = Condition.values();
            boolean isCondition = Arrays.stream(conditions).anyMatch((element -> String.valueOf(element).equals(input)));
            if (isCondition) {
                if (input.equals(String.valueOf(Condition.ICE))) {
                    coffee = new Ice(coffee);
                } else if (input.equals(String.valueOf(Condition.HOT))) {
                    coffee = new Hot(coffee);
                }

                break;
            }
        }

        while (true) {
            System.out.println("Which size do you offer?");
            System.out.println("- Small");
            System.out.println("- Medium");
            System.out.println("- Large");
            String input = scanner.nextLine().toUpperCase();

            CoffeeSize[] coffeeSizes = CoffeeSize.values();
            boolean isCoffeeSize = Arrays.stream(coffeeSizes).anyMatch((element -> String.valueOf(element).equals(input)));
            if (isCoffeeSize) {
                if (input.equals(String.valueOf(CoffeeSize.SMALL))) {
                    coffee = new Small(coffee);
                } else if (input.equals(String.valueOf(CoffeeSize.MEDIUM))) {
                    coffee = new Medium(coffee);
                } else if (input.equals(String.valueOf(CoffeeSize.LARGE))) {
                    coffee = new Large(coffee);
                }

                break;
            }
        }

        while (true) {
            System.out.println("Which options do you offer?");
            System.out.println("- Soy");
            System.out.println("- Mocha");
            System.out.println("- Whip");
            System.out.println("- END");
            String input = scanner.nextLine().toUpperCase();

            CoffeeOptions[] coffeeOptions = CoffeeOptions.values();
            boolean isCoffeeOptions = Arrays.stream(coffeeOptions).anyMatch((element -> String.valueOf(element).equals(input.toUpperCase())));
            if (isCoffeeOptions) {
                if (input.equals(String.valueOf(CoffeeOptions.SOY))) {
                    coffee = new Soy(coffee);
                } else if (input.equals(String.valueOf(CoffeeOptions.MOCHA))) {
                    coffee = new Mocha(coffee);
                } else if (input.equals(String.valueOf(CoffeeOptions.WHIP))) {
                    coffee = new Whip(coffee);
                } else if (input.equals(String.valueOf(CoffeeOptions.END))) {
                    break;
                }

                continue;
            }
        }

        int cost = coffee.cost();
        System.out.println("cost = " + cost);

        String description = coffee.getDescription();
        System.out.println("description = " + description);
    }

}
