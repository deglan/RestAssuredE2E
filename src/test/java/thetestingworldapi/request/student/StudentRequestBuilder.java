package thetestingworldapi.request.student;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import thetestingworldapi.model.student.Student;
import thetestingworldapi.model.student.StudentEntity;
import thetestingworldapi.tests.BaseStudentApiTest;

@Slf4j
public class StudentRequestBuilder extends BaseStudentApiTest {

    public static Response createStudent(Student student) {

        Response response = RestAssured.given()
                .spec(StudentRequestSpecification.StudentPostRqSpec())
                .when()
                .body(student)
                .post();

        log.info("POST response: " + response.body().asPrettyString());
        return response;
    }

    public static Response getStudentDetails(int studentId) {

        Response response = RestAssured.given()
                .spec(StudentRequestSpecification.StudentGetOrDeleteRqSpec(studentId))
                .when()
                .get();

        log.info("GET response for student ID " + studentId + ": " + response.body().asPrettyString());
        return response;
    }

    public static Response updateStudent(int studentId, Student student) {
        StudentEntity studentEntity = new StudentEntity(student);
        studentEntity.setId(studentId);

        Response response = RestAssured.given()
                .spec(StudentRequestSpecification.StudentPutRqSpec(studentId))
                .when()
                .body(studentEntity)
                .put();

        log.info("Response Body: " + response.body().asPrettyString());
        return response;
    }

    public static Response deleteStudent(int studentId) {
        Response response = RestAssured.given()
                .spec(StudentRequestSpecification.StudentDeleteRqSpec(studentId))
                .when()
                .delete();

        log.info("DELETE response: " + response.body().asPrettyString());
        return response;
    }
}
