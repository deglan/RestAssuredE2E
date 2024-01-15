package thetestingworldapi.provider;

import lombok.Data;
import thetestingworldapi.configuration.TestContext;
import thetestingworldapi.model.student.Student;

import java.util.stream.Stream;

@Data
public class StudentProvider {

    private static TestContext testContext = TestContext.getInstance();

    public static Stream<Student> getDefaultStudent() {
        return Stream.of(new Student("John", "Edward", "Doe", "1990-01-01"));
    }

    public static String getMiddleNameToChange() {
        return "Alexander";
    }

    public static Student changeMiddleName(Student student, String middleName) {
        student.setMiddle_name(middleName);
        return student;
    }
}
