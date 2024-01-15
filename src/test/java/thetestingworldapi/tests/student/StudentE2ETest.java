package thetestingworldapi.tests.student;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import thetestingworldapi.model.student.Student;
import thetestingworldapi.provider.StudentProvider;
import thetestingworldapi.request.student.StudentRequestBuilder;
import thetestingworldapi.response.student.StudentResponseHandler;
import thetestingworldapi.tests.BaseStudentApiTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StudentE2ETest extends BaseStudentApiTest {

    @ParameterizedTest()
    @MethodSource("thetestingworldapi.provider.StudentProvider#getDefaultStudent")
    public void end2EndScenario(Student student) {

        //Post
        Response response = StudentRequestBuilder.createStudent(student);
        studentId = StudentResponseHandler.extractStudentId(response);
        assertThat(response)
                .extracting(StudentResponseHandler::extractStatusCode,
                        StudentResponseHandler::extractDateOfBirth)
                .contains(HttpStatus.SC_CREATED, student.getDate_of_birth());

        //Get by id
        response = StudentRequestBuilder.getStudentDetails(studentId);
        studentsDetails = StudentResponseHandler.extractDetailsAsString(response);
        assertThat(studentsDetails).contains(
                student.getFirst_name(),
                student.getLast_name());

        //Put
        String middleName = StudentProvider.getMiddleNameToChange();
        Student updatedStudent = StudentProvider.changeMiddleName(student, middleName);
        response = StudentRequestBuilder.updateStudent(studentId, updatedStudent);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);

        //Get by id check middle name
        response = StudentRequestBuilder.getStudentDetails(studentId);
        studentsDetails = StudentResponseHandler.extractDetailsAsString(response);
        assertThat(studentsDetails).contains(middleName);

        //delete
        response = StudentRequestBuilder.deleteStudent(studentId);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);

        //get by id check if deleted
        response = StudentRequestBuilder.getStudentDetails(studentId);
        assertThat(response)
                .extracting(StudentResponseHandler::extractStatusCode,
                        StudentResponseHandler::extractStatus,
                        StudentResponseHandler::extractMessage)
                .containsExactly(HttpStatus.SC_OK, "false", "No data Found");
    }
}
