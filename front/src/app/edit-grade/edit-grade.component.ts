import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {DataService} from "../service/data.service";
import {student} from "../student";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit-grade',
  templateUrl: './edit-grade.component.html',
  styleUrls: ['./edit-grade.component.css']
})
export class EditGradeComponent {
  myForm: FormGroup;
  student: student = new student('', '', 0);

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private studentService: DataService,
    private fb: FormBuilder
  ) {this.myForm = this.fb.group({
    grade: ['', [Validators.required, Validators.min(1), Validators.max(100)]],
  });}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      const studentId = +params['id']; // Get the student ID from the route
      this.studentService.getStudentById(studentId).subscribe((student) => {
        this.student = student;
      });
    });
  }
  onSubmit(): void {
    this.studentService.updateStudentGrade(this.student).subscribe(() => {
      this.router.navigate(['/students']);
    });
  }
}
