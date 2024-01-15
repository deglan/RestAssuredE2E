package thetestingworldapi.response.student;

import io.restassured.response.Response;

public class StudentResponseHandler {

    public static String extractDetailsAsString(Response response) {
        return response.body().asPrettyString();
    }

    public static int extractStatusCode(Response response) {
        return response.statusCode();
    }

    public static int extractStudentId(Response response) {
        return response.jsonPath().get("id");
    }

    public static String extractStatus(Response response) {
        return response.jsonPath().getString("status");
    }

    public static String extractMessage(Response response) {
        return response.jsonPath().getString("msg");
    }

    public static String extractDateOfBirth(Response response) {
        return response.jsonPath().getString("date_of_birth");
    }
}
