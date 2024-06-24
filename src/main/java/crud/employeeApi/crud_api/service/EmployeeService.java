package crud.employeeApi.crud_api.service;

import crud.employeeApi.crud_api.dto.EmployeeDto;

import java.util.List;

/**
 * @author BARNABA
 * @created 23/06/2024 - 7:41 PM
 * @project crud_api
 */
public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
//    EmployeeDto getAllEmployees();
     List<EmployeeDto> getAllEmployees();
    EmployeeDto getAllEmployeeByID(long id);

    EmployeeDto updateEmployee(EmployeeDto employeeDto, long id);

    void deleteEmployeeById (long id);

}
