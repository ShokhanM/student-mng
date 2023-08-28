import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import {HttpClientModule} from "@angular/common/http";
import { StudentFormComponent } from './student-form/student-form.component';
import {FormsModule} from "@angular/forms";
import { EditGradeComponent } from './edit-grade/edit-grade.component';
import {FilterStudentsPipe} from "./filter-students.pipe";
import {SortStudentsPipe} from "./sort-students.pipe";

@NgModule({
    declarations: [
        AppComponent,
        StudentListComponent,
        StudentFormComponent,
        EditGradeComponent,
        FilterStudentsPipe,
        SortStudentsPipe
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
