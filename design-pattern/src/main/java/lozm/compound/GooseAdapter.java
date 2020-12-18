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

}
