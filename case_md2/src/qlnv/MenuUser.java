package qlnv;

import qlnv.QLNV;

import java.util.Scanner;

public class MenuUser {
    static Scanner sc = new Scanner(System.in);
    static QLNV qlnv = new QLNV();
    public static void Menu() throws Exception {
        while (true) {
            System.out.println("~~~~~ Menu ~~~~~");
            System.out.println("1. Tìm kiếm nhân viên.");
            System.out.println("2. Kiểm tra trạng thái nhân viên.");
            System.out.println("3. Thông tin tài khoản.");
            System.out.println("4. Hiển thị nhân viên");
            System.out.println("5. Sắp xếp theo tên nv");
            System.out.println("6. Hiển thị nhân viên theo trạng thái");
            System.out.println("7. Đăng xuất");

            int choice =0;
            try{
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e){
                System.out.println(" nhập số ");
            }
            switch (choice) {
                case 1 -> qlnv.search();
                case 2 -> qlnv.ktraTrangThai();
                case 3 -> qlnv.hTHiTK();
                case 4 -> qlnv.show();
                case 5 -> qlnv.sortByName();
                case 6 -> qlnv.showNvTheoTT();
                case 7 -> qlnv.logOut();
                default -> System.out.println("nhập lại");
            }
        }
    }
}
