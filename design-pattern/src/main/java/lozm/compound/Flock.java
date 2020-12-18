package lozm.compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackable {

    private List<Quackable> quackers = new ArrayList<>();


    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable item = iterator.next();
            item.quack();
        }
    }

    public void add(Quackable quackable) {
        quackers.add(quackable);
    }


}
