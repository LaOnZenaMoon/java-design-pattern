package lozm.factory;

public abstract class Store {

    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";


    public void buy() {
        System.out.println("buy");

    }

    public void sell() {
        System.out.println("sell");
    }

    public void refund() {
        System.out.println("refund");
    }

}
