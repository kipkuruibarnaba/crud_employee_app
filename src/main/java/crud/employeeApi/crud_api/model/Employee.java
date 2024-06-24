package crud.employeeApi.crud_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author BARNABA
 * @created 23/06/2024 - 7:50 PM
 * @project crud_api
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "employee"
)
public class Employee {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name="employee_name",nullable = false)
    private String employee_name;
    @Column(name="employee_contact",nullable = false)
    private String employee_contact;
    @Column(name="employee_address",nullable = false)
    private String employee_address;
    @Column(name="employee_gender",nullable = false)
    private String employee_gender;
    @Column(name="employee_department",nullable = false)
    private String employee_department;
    @Column(name="employee_skills",nullable = false)
    private String employee_skills;
}
