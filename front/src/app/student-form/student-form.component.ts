import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {student} from "../student";
import {DataService} from "../service/data.service";

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent {
  newStudent = new student('','', 0); // Initialize with an empty student object

  constructor(private studentService: DataService) {}

  onSubmit() {
    // Send the new student data to the server
    this.studentService.addStudent(this.newStudent)
      .subscribe(
        response => {
          console.log('Student added successfully:', response);
          // Optionally, you can reset the form or perform other actions here
          this.newStudent = new student('', '',0); // Reset the form fields
        },
        error => {
          console.error('Error adding student:', error);
        }
      );
  }
}
