package thetestingworldapi.model.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {

    private int id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;

    public StudentEntity(Student student) {
        this.first_name = student.getFirst_name();
        this.middle_name = student.getMiddle_name();
        this.last_name = student.getLast_name();
        this.date_of_birth = student.getDate_of_birth();
    }
}
