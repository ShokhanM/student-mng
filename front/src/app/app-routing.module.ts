import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentListComponent} from "./student-list/student-list.component";
import {StudentFormComponent} from "./student-form/student-form.component";
import {EditGradeComponent} from "./edit-grade/edit-grade.component";

const routes: Routes = [
  { path: '', redirectTo: '/students', pathMatch: 'full' }, // Redirect to /students
  { path: 'students', component: StudentListComponent },
  { path: 'students/:id', component: EditGradeComponent },
  { path: 'add-student', component: StudentFormComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
