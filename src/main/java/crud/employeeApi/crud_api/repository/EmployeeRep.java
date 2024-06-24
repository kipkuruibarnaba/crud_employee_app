package crud.employeeApi.crud_api.repository;

import crud.employeeApi.crud_api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author BARNABA
 * @created 23/06/2024 - 7:49 PM
 * @project crud_api
 */
public interface EmployeeRep extends JpaRepository<Employee,Long> {
}
