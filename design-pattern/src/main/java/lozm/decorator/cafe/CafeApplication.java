package lozm.decorator.cafe;

public class CafeApplication {



    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println("espresso = " + espresso.getDescription() + ", $ " + espresso.cost());

        Beverage houseBlend = new HouseBlend();
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Soy(houseBlend);
        houseBlend = new Whip(houseBlend);
        houseBlend = new Whip(houseBlend);
        System.out.println("houseBlend = " + houseBlend.getDescription() + ", $ " + houseBlend.cost());
    }

}
