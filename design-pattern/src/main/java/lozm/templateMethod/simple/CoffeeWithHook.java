package lozm.templateMethod.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("필터로 커피를 우려내는중");
    }

    @Override
    void addCondiments() {
        System.out.println("설탕과 커피를 준비하는중");
    }

    @Override
    boolean customerWantsCondiments() {
        String answer = getUserInput();

        if (answer.toLowerCase().startsWith("y")) {
            return true;
        }

        return false;
    }

    private String getUserInput() {
        String answer = null;

        System.out.print("커피에 우유와 설탕을 넣어드릴까요? (y/n): ");

        BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in));

        try {
            answer = bufferedInputStream.readLine();
        } catch (IOException ioe) {
            System.err.println("IO 오류");
        }

        if (answer == null) {
            return "no";
        }

        return answer;
    }

}
