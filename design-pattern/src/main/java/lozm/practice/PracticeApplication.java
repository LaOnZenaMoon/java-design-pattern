package lozm.practice;

import lozm.practice.code.Coffee;
import lozm.practice.code.CoffeeOptions;
import lozm.practice.code.CoffeeSize;
import lozm.practice.code.Condition;
import lozm.practice.factory.*;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PracticeFactory coffeeFactory = new CoffeeFactory();
        PracticeFactory conditionFactory = new ConditionFactory();
        PracticeFactory sizeFactory = new SizeFactory();
        PracticeFactory optionsFactory = new OptionsFactory();


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
                coffee = coffeeFactory.order(coffee, input);
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
                coffee = conditionFactory.order(coffee, input);
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
                coffee = sizeFactory.order(coffee, input);
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
                if (input.equals(String.valueOf(CoffeeOptions.END))) {
                    break;
                }

                coffee = optionsFactory.order(coffee, input);
                continue;
            }
        }

        int cost = coffee.cost();
        System.out.println("cost = " + cost);

        String description = coffee.getDescription();
        System.out.println("description = " + description);
    }

}
