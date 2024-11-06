package ie.atu.cicdexam;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService myEmployee;

    public EmployeeController(EmployeeService myEmployee) {
        this.myEmployee = myEmployee;
    }

    @PostMapping("/employees")
    public List<Employee> addEmployee(@Valid @RequestBody Employee employee){
        return myEmployee.addEmployeeService(employee);
        //return ResponseEntity.status(400).body("");
    }

    @GetMapping("/employees/{employeeCode}")
    public List<Employee> retrieveEmployee(@PathVariable String employeeCode){
        return myEmployee.retrieveEmployeeService(employeeCode);
    }

    @PutMapping("/employees/{employeeCode}")
    public List<Employee> updateEmployee(@Valid @RequestBody Employee employee, @Valid @PathVariable String employeeCode){
        return myEmployee.updateEmployeeService(employee, employeeCode);
    }

    @DeleteMapping("/employees/{employeeCode}")
    public List<Employee> deleteEmployee(@Valid @PathVariable String employeeCode){
        return myEmployee.deleteEmployeeService(employeeCode);
    }


}
