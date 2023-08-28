// sort-students.pipe.ts
import { Pipe, PipeTransform } from '@angular/core';
import {student} from './student'; // Import the Student interface

@Pipe({
  name: 'sortStudents',
})
export class SortStudentsPipe implements PipeTransform {
  transform(students: student[], sortBy: string): student[] {
    if (!students || students.length <= 1) return students;

    switch (sortBy) {
      case 'firstName':
        return students.slice().sort((a, b) =>
          a.first_name.localeCompare(b.first_name)
        );
      case 'lastName':
        return students.slice().sort((a, b) =>
          a.last_name.localeCompare(b.last_name)
        );
      default:
        return students;
    }
  }
}
