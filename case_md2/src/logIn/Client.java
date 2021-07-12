package logIn;
import java.util.Scanner;

public class Client {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        subMenu();
    }

        public static void subMenu() throws Exception {
        while (true) {
            System.out.printf("%35s \n","-----QUẢN LÝ NHÂN VIÊN-----");
            System.out.println("1.Đăng nhập");
            System.out.println("2.Đăng kí");
            System.out.println("3.Hiển thị danh sách tài khoản");
            System.out.println("4.Xóa tài khoản");
            System.out.println("5.Đổi mật khẩu");
            System.out.println("6.Exit");
            int choice = 0;
            try {
                 choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e){
                System.out.println("nhập số");
            }
            switch (choice) {
                case 1 -> Qltk.logIn();
                case 2 -> Qltk.taoTk();
                case 3 -> Qltk.hThi();
                case 4 -> Qltk.xoaTk();
                case 5 -> Qltk.suaMk();
                case 6 -> System.exit(0);
                default -> System.out.println("nhập lại");
            }
        }
    }
}


