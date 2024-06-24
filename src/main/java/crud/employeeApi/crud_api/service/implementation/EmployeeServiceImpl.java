package crud.employeeApi.crud_api.service.implementation;

import crud.employeeApi.crud_api.dto.EmployeeDto;
import crud.employeeApi.crud_api.exception.ResourceNotFoundException;
import crud.employeeApi.crud_api.model.Employee;
import crud.employeeApi.crud_api.repository.EmployeeRep;
import crud.employeeApi.crud_api.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author BARNABA
 * @created 23/06/2024 - 7:41 PM
 * @project crud_api
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRep employeeRep;
    private ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRep employeeRep, ModelMapper mapper) {
        this.employeeRep = employeeRep;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //Convert Dto to Entity
        System.out.println("Data to save "+employeeDto);
        Employee employee = mapToEntity(employeeDto);
        Employee newEmployee = employeeRep.save(employee);
        EmployeeDto emplyeeResponse=mapToDTO(newEmployee);
        return emplyeeResponse;
    }

    @Override
//    public EmployeeDto getAllEmployees() {
//        return null;
//    }
    public List<EmployeeDto> getAllEmployees() {
        //Retrieve all employees;
        List<Employee> employees = employeeRep.findAll();
        //Convert list of employees entities to list of card dto's
        return employees.stream().map(employee -> mapToDTO(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getAllEmployeeByID(long id) {
        Employee employee = employeeRep.findById(id).orElseThrow(()->new ResourceNotFoundException("Account", "id", id));
        return mapToDTO(employee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, long id) {

        //Get employee by id from the database
        Employee employee = employeeRep.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "id", id));
        employee.setEmployee_name(employeeDto.getEmployee_name());
        employee.setEmployee_address(employeeDto.getEmployee_address());
        employee.setEmployee_gender(employeeDto.getEmployee_gender());
        employee.setEmployee_department(employeeDto.getEmployee_department());
        employee.setEmployee_contact(employeeDto.getEmployee_contact());
        employee.setEmployee_skills(employeeDto.getEmployee_skills());
        Employee updatedEmplyee = employeeRep.save(employee);
        return mapToDTO(updatedEmplyee);
    }

    @Override
    public void deleteEmployeeById(long id) {
        //Retrieve Employee entity by id
        Employee employee = employeeRep.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee", "id", id));
         employeeRep.delete(employee);
    }

    //Convert Entity into DTO
    private EmployeeDto mapToDTO(Employee employee) {
//        EmployeeDto employeeDto =mapper.map(employee,EmployeeDto.class);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setEmployee_name(employee.getEmployee_name());
        employeeDto.setEmployee_contact(employee.getEmployee_contact());
        employeeDto.setEmployee_address(employee.getEmployee_address());
        employeeDto.setEmployee_gender(employee.getEmployee_gender());
        employeeDto.setEmployee_department(employee.getEmployee_department());
        employeeDto.setEmployee_skills(employee.getEmployee_skills());
        return employeeDto;
    }
    //Convert DTO to  Entity
    private Employee mapToEntity(EmployeeDto employeeDto){
//        Employee employee = mapper.map(employeeDto,Employee.class);
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setEmployee_name(employeeDto.getEmployee_name());
        employee.setEmployee_contact(employeeDto.getEmployee_contact());
        employee.setEmployee_address(employeeDto.getEmployee_address());
        employee.setEmployee_gender(employeeDto.getEmployee_gender());
        employee.setEmployee_department(employeeDto.getEmployee_department());
        employee.setEmployee_skills(employeeDto.getEmployee_skills());
        return employee;
    }
}
