package view;

import controller.ManagerStudent;
import model.Student;

import java.util.Scanner;

public class MenuStudent {
    public static void ManagerStudentMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---------QUẢN LÝ SÁCH-----------");
            System.out.println("1. Thêm sinh viên mới");
            System.out.println("2. Hiển thị tất cả sinh viên");
            System.out.println("3. Tìm kiếm sinh viên ");
            System.out.println("4. Xóa sinh viên theo mã");
            System.out.println("5. Cập nhật thông tin sinh viên");
            System.out.println("6. Sắp xếp sinh viên");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Student newStudent = createNewStudent();
                    ManagerStudent.addNewStudent(newStudent);
                    break;
                case 2:
                    System.out.println("\nDanh sách sinh viên:");
                    ManagerStudent.displayStudents();
                    break;
                case 3:
                    System.out.print("Nhập mã sinh viên cần tìm theo id: ");
                    String sutdentId = scanner.nextLine();
                    ManagerStudent.findStudent(sutdentId);
                    break;
                case 4:
                    System.out.println("Nhập mã sinh viên cần xóa: ");
                    String studentToRemove = scanner.nextLine();
                    ManagerStudent.removeStudent(studentToRemove);
                    break;
                case 5:
                    System.out.print("Nhập mã sinh viên cần cập nhật: ");
                    String studentIdToEdit = scanner.nextLine();
                    Student updatedStudent = createNewStudent();
                    ManagerStudent.editStudent(studentIdToEdit, updatedStudent);
                    break;
                case 6 :
                    System.out.println("Sắp xếp sinh viên: ");
                    ManagerStudent.sortStudent();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
                    break;
            }
        } while (choice != 0);
    }

    public static Student createNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập id: ");
        String studentId = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập điểm trung bình: ");
        double averagescore = scanner.nextDouble();
        scanner.nextLine();


        return new Student(studentId, name, age, gender, address,averagescore);
    }
}

