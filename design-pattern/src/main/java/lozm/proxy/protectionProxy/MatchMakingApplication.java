package lozm.proxy.protectionProxy;

import java.lang.reflect.Proxy;

public class MatchMakingApplication {

    public static void main(String[] args) {
        MatchMakingApplication matchMaking = new MatchMakingApplication();
        matchMaking.drive();
    }


    public MatchMakingApplication() {
        initializeDatabase();
    }


    public void drive() {
        PersonBean joe = getPersonFromDatabase("Joe Javabean");
        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());

        ownerProxy.setInterests("bowling, Go");
        System.out.println("Interests set from owner proxy");

        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't see rating from owner proxy.");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());

        try {
            nonOwnerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't see rating from owner proxy.");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Rating set from non owner proxy.");
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
    }

    private PersonBean getPersonFromDatabase(String name) {
        PersonBeanImpl personBean = new PersonBeanImpl();
        personBean.setName(name);
        return personBean;
    }

    private void initializeDatabase() {

    }

    private PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new OwnerInvocationHandler(personBean)
        );
    }

    private PersonBean getNonOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(personBean)
        );
    }

}
