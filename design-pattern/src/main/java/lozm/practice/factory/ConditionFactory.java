package lozm.practice.factory;

import lozm.practice.Component;
import lozm.practice.code.Condition;
import lozm.practice.condition.Hot;
import lozm.practice.condition.Ice;

public class ConditionFactory extends PracticeFactory {

    @Override
    protected Component createComponent(Component component, String type) {
        if (type.equals(String.valueOf(Condition.ICE))) {
            component = new Ice(component);
        } else if (type.equals(String.valueOf(Condition.HOT))) {
            component = new Hot(component);
        }

        return component;
    }

}
