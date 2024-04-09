package controller;

import model.Student;
import storage.IReadWriteFileStudent;
import storage.ReadWriteFileStudent;

import java.util.Comparator;
import java.util.List;

public class ManagerStudent {

    private static final IReadWriteFileStudent readWriteFile = new ReadWriteFileStudent();
    private static final List<Student> students = readWriteFile.readFile();

    public static void addNewStudent(Student student) {
        students.add(student);
        readWriteFile.writeFile(students);
        System.out.println("Sinh viên đã được thêm thành công.");
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.err.println("Không có sinh viên nào.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void findStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                System.out.println("Sinh viên được tìm thấy: " + student);
                return;
            }
        }
        System.err.println("Không tìm thấy sinh viên với mã: " + studentId);
    }

    public static void removeStudent(String studentId) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            readWriteFile.writeFile(students);
            System.out.println("Sinh viên đã được xóa.");
        } else {
            System.err.println("Không tìm thấy sinh viên với mã: " + studentId);
        }
    }

    public static void editStudent(String StudentId, Student updatedStudent) {
        int studentIndex = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(StudentId)) {
                studentIndex = i;
                break;
            }
        }
        if (studentIndex != -1) {

            students.set(studentIndex, updatedStudent);
            readWriteFile.writeFile(students);
            System.out.println("Sinh viên đã được cập nhật thành công.");
        } else {
            System.err.println("Không tìm thấy sinh viên với mã: " + StudentId);
        }
    }

    public static void sortStudent() {
        students.sort(Comparator.comparing(Student::getId));
        displayStudents();
    }


}


