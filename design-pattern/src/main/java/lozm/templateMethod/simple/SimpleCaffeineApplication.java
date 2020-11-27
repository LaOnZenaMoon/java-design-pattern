package lozm.templateMethod.simple;

public class SimpleCaffeineApplication {

    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();

        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();

        CaffeineBeverage coffeeWithHook = new CoffeeWithHook();
        coffeeWithHook.prepareRecipe();
    }

}
