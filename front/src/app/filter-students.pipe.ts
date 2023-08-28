import {Pipe, PipeTransform} from "@angular/core";
import {student} from "./student";

@Pipe({
  name: 'filterStudents',
})
export class FilterStudentsPipe implements PipeTransform {
  transform(students: student[], filterText: string): student[] {
    if (!filterText) return students;

    filterText = filterText.toLowerCase();
    return students.filter(
      (student) =>
        student.first_name.toLowerCase().includes(filterText) ||
        student.last_name.toLowerCase().includes(filterText)
    );
  }
}
