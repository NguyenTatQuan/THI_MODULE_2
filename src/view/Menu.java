package view;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---------MENU QUẢN LÝ SINH VIÊN   -----------");
            System.out.println("1. Quản lý sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    MenuStudent.ManagerStudentMenu();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

}

