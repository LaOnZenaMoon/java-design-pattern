package lozm;

public class Test {

    Integer i;
    int j;

    public static void main(String[] args) {
        Test test = new Test();
        test.go();
    }

    private void go() {
        j = i;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }

}
