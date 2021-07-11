package qlnv;

import logIn.Client;
import logIn.Qltk;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QLNV {
    static Scanner sc =  new Scanner(System.in);
    static File nhanVien = new File("nhanVien.txt");
    static ArrayList<NhanVien> list = new ArrayList<>();

    public void them( ) throws IOException {
            System.out.println("1.thêm nhân viên fulltime");
            System.out.println("2.thêm nhân viên parttime");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                NhanVien nv = taoNv("full");
                list.add(nv);
            } else {
                NhanVien nv = taoNv("part");
                list.add(nv);
        }
            ghiFile();
    }

    public void search(){
        list = docFile();
        System.out.println("nhập tên cần tìm kiếm thông tin");
        String name = sc.nextLine();
        boolean check = false;
        for (NhanVien nv : list){
            if(nv.getName().contains(name)){
                System.out.println(nv);
            }else if(!(nv.getName().equals(name))){
                check = true;
            }
        }
        if (check){
            System.out.println("không tìm thấy nhân viên " + name);
        }
    }

    public void xoa() throws IOException {
        list = docFile();
        System.out.println("nhập mã nhân viên");
        int id = Integer.parseInt(sc.nextLine());
        for (int i =0; i< list.size(); i++){
            if (list.get(i).getId() == id){
                list.remove(i);
            }
        }
        ghiFile();
    }

    public void capNhat() throws IOException {
        list = docFile();
        System.out.println("nhập id của nhân viên cần sửa");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i<list.size(); i++){
            if (list.get(i).getId() == id){
                if (list.get(i) instanceof NvFull){
                    list.set(i, taoNv("full"));
                }else list.set(i, taoNv("part"));
            }
        }
        ghiFile();
    }

    public void ktraTrangThai(){
        list = docFile();
        System.out.println("nhập tên nhân viên muốn kiểm tra trạng thái");
        String name = sc.nextLine();
        for (NhanVien nv : list){
            if (nv.getName().equals(name)){
                System.out.println("trạng thái: "+ nv.getTrangThai());
            }
        }
    }

    public void suaTrangThai() throws IOException {
        System.out.println("nhập tên nhân viên muốn thay đổi trạng thái");
        String name = sc.nextLine();
        for (NhanVien nv : list){
            if (nv.getName().equals(name)){
                nv.setTrangThai(getTrangThai());
                System.out.println(nv);
            }
        }
        ghiFile();
    }

    public void showNvTheoTT() throws IOException {
        list = docFile();
        System.out.println("1.true");
        System.out.println("2.false");
        int choice = Integer.parseInt(sc.nextLine());
        if(choice ==1){
            for (int i =0; i<list.size(); i++) {
                if (list.get(i).getTrangThai().equals("true")) {
                    System.out.println(list.get(i));
                }
            }
        }
        if (choice==2){
            for (int i =0; i<list.size(); i++) {
                if (list.get(i).getTrangThai().equals("false")) {
                    System.out.println(list.get(i));
                }
            }
        }
        ghiFile();
    }

    public void sortByName() throws IOException {
        SortByName sortByName = new SortByName();
        list.sort(sortByName);
        ghiFile();
    }

    public void  hTHiTK() throws Exception {
        Qltk.hThiTKDN();
    }

    public void show(){
        list = docFile();
        for (NhanVien nv : list) {
            System.out.println(nv);
        }
    }

    public int getId() {
        while (true) {
            try {
                System.out.println("nhập id");
                int id = Integer.parseInt(sc.nextLine());
                list = docFile();
                for (NhanVien nv : list) {
                    if (nv.getId() == id) {
                        throw new Loi();
                    }
                }
                return id;
            } catch (Loi e) {
                System.out.println("id bị trùng");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        while (true) {
                boolean flag;
                do {
                    System.out.println("nhập tên");
                    String name = sc.nextLine();
                    flag = SdtEmailRegex.validateName(name);
                    if (flag) {
                        return name;
                    } else System.out.println("tên không hợp lệ");
                } while (!flag);
        }
    }

    public String getSDT() {
        while (true) {
            boolean flag;
            do {
                System.out.println("nhập số điện thoại(0XXXXXXXXX)");
                String sdt = sc.nextLine();
                flag = SdtEmailRegex.validateSDT(sdt);
                if (flag){
                    return sdt;
                } else System.out.println("số điện thoại chưa hợp lệ");
            } while (!flag);
        }
    }

    public String getDiaChi(){
        System.out.println("nhập địa chỉ");
        return sc.nextLine();
    }

    public String getTrangThai(){
        while (true){
            try {
                System.out.println("nhập trạng thái( true or false)");
                String trangThai = sc.nextLine();
                if (trangThai.equals("true")||trangThai.equals("false")){
                    return trangThai;
                } else throw new Loi();
            }
            catch (Loi e){
                System.out.println("trạng thái là true hoặc false");
            }
        }
    }

    public double getTime(){
        System.out.println("nhập số giờ");
        return Double.parseDouble(sc.nextLine());
    }

    public String getEmail() {
        while (true) {
            try {
                boolean flag;
                do {
                    System.out.println("nhập email");
                    String email = sc.nextLine();
                    flag = SdtEmailRegex.validateEmail(email);
                    if (flag) {
                        list = docFile();
                        for (NhanVien nv : list) {
                            if (nv.getEmail().equals(email)) {
                                throw new Loi();
                            }
                        }
                        return email;
                    } else System.out.println("email chưa hợp lệ");
                } while (!flag);
            } catch (Loi e) {
                System.out.println(" email bị trùng");
            }
        }
    }

    public String gioiTinh(){
        while (true){
            try {
                System.out.println("nhập giới tính( nam hoặc nu )");
                String gender = sc.nextLine();
                if (gender.equals("nam")||gender.equals("nu")){
                    return gender;
                } else throw new Loi();

            }
            catch (Loi e){
                System.out.println("nam hoặc nữ");
            }
        }
    }

    public int age(){
        while (true) {
            try {
                System.out.println("nhập tuổi");
                int age = Integer.parseInt(sc.nextLine());
                if (age < 18) {
                    throw new Loi();
                } else {
                    return age;
                }
            } catch (Loi e) {
                System.out.println("chưa đủ tuổi lao động");
            } catch (Exception e) {
                System.out.println("tuổi là số");
            }
        }
    }

    public double luong(){
        while (true){
            try {
                System.out.println("nhập lương");
                return Double.parseDouble(sc.nextLine());

            }
            catch (Exception e){
                System.out.println("nhập số");
            }
        }
    }

    public static  void ghiFile() throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(nhanVien);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (NhanVien nv : list){
                bufferedWriter.write(nv.ghi());
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            bufferedWriter.close();
        }
    }

    public static ArrayList<NhanVien> docFile()  {
        ArrayList<NhanVien> list1 = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(nhanVien);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {

//                System.out.println(line);
                String[] str = line.split(",");
                if (str.length >= 9) {
                   //String name,int id, int age, String sdt, String gender, String email, String diaChi, double luong, String trangThai
                    list1.add(new qlnv.NhanVien(str[0].trim(), Integer.parseInt(str[1].trim()), Integer.parseInt(str[2].trim()), str[3].trim(), str[4].trim(), str[5].trim(),str[6].trim(), Double.parseDouble(str[7].trim()),str[8].trim()));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
        }
        return  list1;
    }

    public NhanVien taoNv(String kieuNv){
        if (kieuNv.equals("full")) {
            return new NvFull(getName(), getId(), age(), getSDT(), gioiTinh(), getEmail(), getDiaChi(), luong(), getTrangThai() );
        } else {
            return new NvPartime(getName(), getId(), age(), getSDT(), gioiTinh(), getEmail(), getDiaChi(), luong(), getTrangThai(), getTime());
        }
    }

    public void logOut() throws Exception {
        Qltk.logOut();
        Client.subMenu();
    }
}
