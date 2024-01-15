package thetestingworldapi.tests;

import io.restassured.RestAssured;
import lombok.Data;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import thetestingworldapi.configuration.TestContext;

@Data
public class BaseStudentApiTest {

    protected static TestContext testContext = TestContext.getInstance();
    protected static String studentDetailsEndpoint;
    protected static String studentDetailsWithIdEndpoint;
    protected int studentId;
    protected String studentsDetails;

    @BeforeAll
    public static void setUpClass() {
        testContext.loadConfigurations("src/test/resources/");
        studentDetailsEndpoint = testContext.getProperty("endpoints.studentDetails");
        studentDetailsWithIdEndpoint = testContext.getProperty("endpoints.specificStudentDetails");
    }

    @BeforeEach
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = testContext.getProperty("endpoints.baseUri");
    }
}
