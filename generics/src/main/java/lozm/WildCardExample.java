package lozm;

import java.util.Arrays;

public class WildCardExample {

    public static void registerCourse(Course<?> course) {
        System.out.println(course.getName() + "수강생: " + Arrays.toString(course.getStudents()));
    }

}