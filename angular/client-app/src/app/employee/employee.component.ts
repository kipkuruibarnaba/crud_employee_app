import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.mode';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employee: Employee ={
    Id:0,
    employeeName:'',
    employeeContact:'',
    employeeAddress:'',
    employeeGender:'',
    employeeDepartemnt:'',
    employeeSkills:''
  }
  constructor(){

  }
  ngOnInit(): void {
      throw new Error('Method not Implemented');
  }
}
