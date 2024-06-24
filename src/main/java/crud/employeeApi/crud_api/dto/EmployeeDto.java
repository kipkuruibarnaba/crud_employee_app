package crud.employeeApi.crud_api.dto;

import jakarta.persistence.Column;
import lombok.Data;

/**
 * @author BARNABA
 * @created 23/06/2024 - 7:42 PM
 * @project crud_api
 */
@Data
public class EmployeeDto {
    private Long id;
    private String employee_name;
    private String employee_contact;
    private String employee_address;
    private String employee_gender;
    private String employee_department;
    private String employee_skills;
}
