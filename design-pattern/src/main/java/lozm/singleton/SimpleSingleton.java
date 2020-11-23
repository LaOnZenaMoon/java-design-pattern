package lozm.singleton;

public class SimpleSingleton {

    private static SimpleSingleton uniqueInstance;

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SimpleSingleton();
        }

        return uniqueInstance;
    }

}
