package lozm.practice.factory;

import lozm.practice.Component;

public abstract class PracticeFactory {

    public Component order(Component component, String type) {
        Component result = createComponent(component, type);
        System.out.println("result.getDescription() = " + result.getDescription());
        System.out.println("result.cost() = " + result.cost());

        return result;
    }

    protected abstract Component createComponent(Component component, String type);

}
