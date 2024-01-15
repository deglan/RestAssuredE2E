package thetestingworldapi.model.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;
}
