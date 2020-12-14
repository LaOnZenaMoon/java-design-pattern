package lozm.serialize;

import java.io.*;

public class SerializeMain {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.setName("Americano");
        coffee.setSize("Tall");
        coffee.setPrice(1000);
        coffee.setSecret("main secret");

        System.out.println("coffee = " + coffee);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.txt"))) {
            objectOutputStream.writeObject(coffee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.txt"));
            Coffee o = (Coffee)objectInputStream.readObject();
            System.out.println("o = " + o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
