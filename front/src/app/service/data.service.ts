import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {student} from "../student";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private apiUrl = 'http://localhost:8080/api/student/';

  constructor(private http: HttpClient) { }

  getStudents(): Observable<student[]> {
    return this.http.get<student[]>(this.apiUrl);
  }
  addStudent(student: student) {
    return this.http.post(this.apiUrl, student);
  }

  updateStudentGrade(student: student) {
    return this.http.put(this.apiUrl, student);
  }

  getStudentById(id: number): Observable<student> {
    // Implement your GET request to fetch a student by ID from the API
    return this.http.get<student>(`${this.apiUrl}${id}`);
  }

}
