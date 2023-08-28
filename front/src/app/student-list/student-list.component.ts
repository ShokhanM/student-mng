import {Component, OnInit} from '@angular/core';
import {DataService} from "../service/data.service";
import {student} from "../student";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit{
  filterText = '';
  sortBy = '';
  students: student[] = [];

  constructor(private studentService : DataService) {
  }

  ngOnInit(): void {
    this.studentService.getStudents().subscribe((data)=>{
      this.students = data;
    })
  }
  onGradeChanged(newGrade: number) {
    // Update the student's grade in the students array
    // This could also involve refreshing the entire list from the backend
    const updatedStudent = this.students.find((student) => student.id === student.id);
    if (updatedStudent) {
      updatedStudent.grade = newGrade;
    }
  }

}
