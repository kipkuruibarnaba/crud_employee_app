package crud.employeeApi.crud_api.controller;

import crud.employeeApi.crud_api.dto.EmployeeDto;
import crud.employeeApi.crud_api.model.Employee;
import crud.employeeApi.crud_api.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author BARNABA
 * @created 23/06/2024 - 7:40 PM
 * @project crud_api
 */
@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    public EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @PostMapping("/save/employee")
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return  new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }
    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //Get single employee by id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable (name="id") long id){
        return ResponseEntity.ok(employeeService.getAllEmployeeByID(id));
    }
    //Update account by id rest api
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto>updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable (name="id") long id){
        EmployeeDto employee = employeeService.updateEmployee(employeeDto ,id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    //Delete account by id rest api

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable (name="id") long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee deleted successfully. ", HttpStatus.OK);
    }
}
