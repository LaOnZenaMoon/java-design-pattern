package lozm.factory.simple;

public class StoreApplication {

    public static void main(String[] args) {
        StoreManage storeManage = new StoreManage(new SimpleStoreFactory());
        storeManage.orderStore("A");
        storeManage.orderStore("B");
    }

}
