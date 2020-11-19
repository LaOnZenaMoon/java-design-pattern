package lozm.factory;

public class StoreA extends Store {

    @Override
    public void buy() {
        System.out.println("STORE A buy");
    }

    @Override
    public void sell() {
        System.out.println("STORE A sell");
    }

}
