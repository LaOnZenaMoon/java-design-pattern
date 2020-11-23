package lozm.singleton;

public class VolatileSingleton {

    private volatile static VolatileSingleton uniqueInstance;

    private VolatileSingleton() {
    }

    //DCL(Double-Checking Locking)
    public static VolatileSingleton getInstance() {
        if(uniqueInstance == null) {
            synchronized (VolatileSingleton.class) {
                if(uniqueInstance == null) {
                    uniqueInstance = new VolatileSingleton();
                }
            }
        }

        return uniqueInstance;
    }

}
