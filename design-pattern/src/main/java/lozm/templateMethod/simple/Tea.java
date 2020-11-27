package lozm.templateMethod.simple;

public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("차를 우려내는중");
    }

    @Override
    void addCondiments() {
        System.out.println("레몬을 추가하는중");
    }
}
