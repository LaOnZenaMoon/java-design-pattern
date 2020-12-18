package lozm.compound;

public class GooseAdapter implements Quackable {

    private Goose goose;


    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }


    @Override
    public void quack() {
        goose.honk();
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }

}
