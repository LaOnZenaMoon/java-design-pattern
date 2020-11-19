package lozm.factory;

public class SimpleStoreFactory {

    public Store createStore(String type) {
        Store store = null;

        if (Store.A.equals(type)) {
            store = new StoreA();
        } else if (Store.B.equals(type)) {
            store = new StoreB();
        } else if (Store.C.equals(type)) {
            store = new StoreC();
        }

        return store;
    }

}
