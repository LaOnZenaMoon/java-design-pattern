package lozm.factory;

public class StoreManage {

    SimpleStoreFactory simpleStoreFactory;


    public StoreManage(SimpleStoreFactory simpleStoreFactory) {
        this.simpleStoreFactory = simpleStoreFactory;
    }


    public Store orderStore(String type) {
        Store store = simpleStoreFactory.createStore(type);

        store.buy();
        store.sell();
        store.refund();

        return store;
    }

}
