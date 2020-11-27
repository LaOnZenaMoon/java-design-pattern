package lozm.templateMethod.simple;

public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();

        if(customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("물을 끓이는중");
    }

    void pourInCup() {
        System.out.println("컵에 따르는중");
    }

    // hook 메소드
    boolean customerWantsCondiments() {
        return true;
    }

}
