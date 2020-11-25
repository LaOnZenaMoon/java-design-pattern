package lozm.adapter.simple;

public class SimpleAdapterApplication {

    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);

        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }

}
