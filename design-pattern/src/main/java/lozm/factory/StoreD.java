package lozm.factory;

public class StoreD extends StoreMethodFactory {

    @Override
    Store createStore(String type) {
        Store store = null;

        if (StoreA.A.equals(type)) {
            store = new StoreA();
        } else if (StoreA.B.equals(type)) {
            store = new StoreB();
        }

        return store;
    }

}
