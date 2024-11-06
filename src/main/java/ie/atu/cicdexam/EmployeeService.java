package ie.atu.cicdexam;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {
    private List<Employee> myList = new ArrayList<>();

    public List<Employee> addEmployeeService(Employee employee){
        myList.add(employee);
        return myList;
    }

    public List<Employee> retrieveEmployeeService(String employeeCode){
        for(Employee e: myList){
            if(e.getEmployeeCode() == employeeCode){
                return myList;
            }
        }throw new NoSuchElementException();
    }

    public List<Employee> updateEmployeeService(Employee employee, String employeeCode){
        for(Employee e: myList){
            if(e.getEmployeeCode() == employeeCode){
                e.setName(employee.getName());
                e.setEmail(employee.getEmail());
                e.setPosition(employee.getPosition());
                e.setSalary(employee.getSalary());
                e.setDateOfJoining(employee.getDateOfJoining());
                return myList;
            }
        }throw new NoSuchElementException();
    }

    public List<Employee> deleteEmployeeService(String employeeCode){
       myList.removeIf(e->e.getEmployeeCode()==employeeCode);
       return myList;
    }
}
