package ie.atu.cicdexam;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService myEmployee;

    public EmployeeController(EmployeeService myEmployee) {
        this.myEmployee = myEmployee;
    }

    @PostMapping("/employees")
    public List<Employee> addEmployee(@Valid Employee employee){
        return myEmployee.addEmployeeService(employee);
    }

    @GetMapping("/employees/{employeeCode}")
    public List<Employee> retrieveEmployee(@Valid Employee employee, @Valid @PathVariable String employeeCode){
        return myEmployee.retrieveEmployeeService(employee, employeeCode);
    }

    @PutMapping("/employees/{employeeCode}")
    public List<Employee> updateEmployee(@Valid Employee employee, @Valid @PathVariable String employeeCode){
        return myEmployee.updateEmployeeService(employee, employeeCode);
    }

    @DeleteMapping("/employees/{employeeCode}")
    public List<Employee> updateEmployee(@Valid Employee employee, @Valid @PathVariable String employeeCode){
        return myEmployee.deleteEmployeeService(employee, employeeCode);
    }


}
