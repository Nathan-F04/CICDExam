package ie.atu.cicdexam;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Pattern(regexp="^EMP-[0-9]{4}$",message="Enter a valid Employee code.")
    private String employeeCode;
    @Max(value = 100,message = "Please enter a max of 100 characters")
    private String name;
    @Email(message="Please enter a valid Email")
    private String email;
    //@Pattern(regexp="^Manager$" | regexp="^Analyst$" | regexp="^Developer$",message="Must be a Manager, Developer or Analyst.")
    private String position;
    @Positive(message="You must enter a positive Salary")
    private int salary;
    @PastOrPresent(message="Date must be today or earlier")
    private String dateOfJoining;
}
