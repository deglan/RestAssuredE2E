package thetestingworldapi.request.student;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import thetestingworldapi.tests.BaseStudentApiTest;

import static io.restassured.RestAssured.given;

public class StudentRequestSpecification extends BaseStudentApiTest {

    public static RequestSpecification StudentPostRqSpec() {
        return given()
                .basePath(studentDetailsEndpoint)
                .contentType(ContentType.JSON);
    }

    public static RequestSpecification StudentGetOrDeleteRqSpec(int studentId) {
        return given()
                .basePath(studentDetailsWithIdEndpoint)
                .pathParam("id", studentId)
                .log().ifValidationFails();
    }

    public static RequestSpecification StudentDeleteRqSpec(int studentId) {
        return given()
                .basePath(studentDetailsWithIdEndpoint)
                .pathParam("id", studentId);
    }

    public static RequestSpecification StudentPutRqSpec(int studentId) {
        return given()
                .basePath(studentDetailsWithIdEndpoint)
                .contentType(ContentType.JSON)
                .pathParam("id", studentId);
    }
}
