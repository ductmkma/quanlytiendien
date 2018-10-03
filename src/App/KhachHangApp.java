/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import CheckData.CheckData;
import CheckData.Utils;
import Object.KhachHang;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KhachHangApp {

    ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
    private String fileName = "data/khachhang.txt";
    CheckData check = new CheckData();
    Utils util = new Utils();

    public void docFileKH() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listKH = new ArrayList<>();

            fr = new FileReader(this.fileName);
            br = new BufferedReader(fr);
            String s = null;
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(arr[0]);
                    kh.setHoTen(arr[1]);
                    kh.setSoDienThoai(arr[2]);
                    kh.setEmail(arr[3]);
                    kh.setDiaChi(arr[4]);
                    kh.setSoCongTo(arr[5]);
                    listKH.add(kh);
                }
            } catch (IOException ex) {
                Logger.getLogger(KhachHangApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KhachHangApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ghiFileKH() {
        try {
            BufferedWriter bw = null;
            FileWriter fw = null;
            String data = "";
            for (int i = 0; i < listKH.size(); i++) {
                String row = "";
                row += listKH.get(i).getMaKH() + "\t";
                row += listKH.get(i).getHoTen() + "\t";
                row += listKH.get(i).getSoDienThoai() + "\t";
                row += listKH.get(i).getEmail() + "\t";
                row += listKH.get(i).getDiaChi() + "\t";
                row += listKH.get(i).getSoCongTo() + "\n";
                data += row;
            }
            fw = new FileWriter(this.fileName);
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(KhachHangApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void menuKH(){
        docFileKH();
        int chon;
        do {
            System.out.println("+------------------QUẢN LÝ KHÁCH HÀNG----------------+");
            System.out.println("|         1. Xem danh sách toàn bộ khách hàng        |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("|       2. Tìm kiếm khách hàng theo MSKH/PHONE/EMAIL |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("|               3. Thêm mới khách hàng               |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("|              4. Sửa thông tin khách hàng           |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("|              5. Xóa thông tin khách hàng           |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("|              6. Quay lại MENU QUẢN LÝ CHUNG        |");
            System.out.println("+----------------------------------------------------+");
            System.out.print("Mời bạn chọn chức năng: ");
            Scanner input = new Scanner(System.in);
            chon = input.nextInt();
            switch (chon) {
                case 1: {
                    xemDanhSach(listKH);
                }
                break;
                case 2: {
                    xemDanhSach(timKiemTheoTuKhoa());
                }
                break;
                case 3: {

                    themKhachHang();
                }
                break;
                case 4: {
                    suaKhachHang();

                }
                break;
                case 5: {
                    xoaKhachHang();

                }
                break;
                case 6: {
                    break;
                }
                default: {
                    System.out.println("Bạn chọn sai chức năng !");
                }
            }
        } while (chon != 6);
    }
    public void xemDanhSach(ArrayList<KhachHang> list) {
        if (list.isEmpty()) {
            System.err.println("Chưa có khách hàng nào trong danh sách !");
            System.out.println("");
        } else {
            System.out.println("+--------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                             DANH SÁCH KHÁCH HÀNG                                       |");
            System.out.println("+---------+---------------------+-------------+--------------------------+------------------+------------+");
            System.out.println("|  MÃ KH  |        HỌ TÊN       |      SĐT    |            EMAIL         |       ĐỊA CHỈ    | SỐ CÔNG TƠ |");
            System.out.println("+---------+---------------------+-------------+--------------------------+------------------+------------+");
            for (int i = 0; i < list.size(); i++) {
                list.get(i).inTT();
            }
            System.out.println("+--------------------------------------------------------------------------------------------------------+");
        }
    }

    public boolean kiemTraMaKH(String maKH) {
        boolean check = false;
        KhachHang kh = new KhachHang();
        for (int i = 0; i < listKH.size(); i++) {
            kh = listKH.get(i);
            if (maKH.equalsIgnoreCase(kh.getMaKH()) == true) {
                check = true;
                break;
            }
        }
        return check;
    }

    public void themKhachHang() {
        KhachHang kh = new KhachHang();
        Scanner input = new Scanner(System.in);
        System.out.println("Mời bạn nhập thông tin để tạo mới khách hàng");
        do {
            System.out.print("Nhập Mã Số Khách Hàng: ");
            kh.setMaKH(input.nextLine());
            if ("".equals(kh.getMaKH()) == true) {
                System.err.println("Mã KH không được bỏ trống ! ");
            }
        } while ("".equals(kh.getMaKH()));
        if (kiemTraMaKH(kh.getMaKH()) == true) {
            System.err.println("Mã khách hàng đã tồn tại ! Thêm không thành công ");
            System.out.println("");

        } else {
            do {
                System.out.print("Nhập Tên Khách Hàng: ");
                kh.setHoTen(input.nextLine());
                if (check.kiemTraTen(kh.getHoTen())) {
                    System.err.println("Tên không được chứa số hoặc rỗng");
                }
            } while (check.kiemTraTen(kh.getHoTen()));
            kh.setHoTen(util.chuanHoaVietHoa(kh.getHoTen()));
            do {
                System.out.print("Nhập SĐT Khách Hàng: ");
                kh.setSoDienThoai(input.nextLine());
            } while (check.kiemTraSoDienThoai(kh.getSoDienThoai()));
            do {
                System.out.print("Nhập Email Khách Hàng: ");
                kh.setEmail(input.nextLine());
            } while (check.kiemTraEmail(kh.getEmail()));
            do {
                System.out.print("Nhập Địa Chỉ Khách Hàng: ");
                kh.setDiaChi(input.nextLine());
                if ("".equals(kh.getDiaChi())) {
                    System.err.println("Địa chỉ khách hàng không được bỏ trống !");
                    System.out.println("\t");
                }
            } while ("".equals(kh.getDiaChi()));
            do {
                System.out.print("Nhập Số Công Tơ Khách Hàng: ");
                kh.setSoCongTo(input.nextLine());
                if ("".equals(kh.getSoCongTo())) {
                    System.err.println("Số công tơ không được bỏ trống !");
                    System.out.println("\t");
                }
            } while ("".equals(kh.getSoCongTo()));
            listKH.add(kh);
            ghiFileKH();
            System.err.println("Thêm mới khách hàng thành công !");
            System.out.println("");
        }

    }

    public void suaKhachHang() {
        Scanner sc = new Scanner(System.in);
        KhachHang kh;
        do {
            System.out.println("Mời bạn nhập mã KH cần sửa: ");
            String maKH = sc.nextLine();
            kh = timKiemMotKhachHang(maKH);
            if (kh == null) {
                System.err.println("Mã khách hàng bạn vừa nhập không tồn tại !");
                System.out.println("Vui lòng thử lại...");
            }
        } while (kh == null);
        if (kh != null) {
            String hoTenCu = kh.getHoTen();
            String SDTCu = kh.getSoDienThoai();
            String emailCu = kh.getEmail();
            String diaChiCu = kh.getDiaChi();
            String soCongToCu = kh.getSoCongTo();
            System.err.println("Mời bạn cập nhật thông tin khách hàng");
            System.out.println("");
            System.err.println("Lưu ý: Nhấn ENTER để bỏ qua nếu bạn không muốn cập nhật thông tin đó !");
            System.out.println("");
            System.out.println("Mã khách hàng:" + kh.getMaKH());
            System.out.println("Tên khách hàng cũ: " + kh.getHoTen());
            do {
                System.out.print("Nhập tên khách hàng mới: ");
                kh.setHoTen(sc.nextLine());
                if ("".equals(kh.getHoTen())) {
                    kh.setHoTen(hoTenCu);
                    break;
                }
                if (check.kiemTraSuaTen(kh.getHoTen())) {
                    System.err.println("Tên khách hàng không được chứa số!!!");
                    System.out.println("");
                }
            } while (check.kiemTraSuaTen(kh.getHoTen()));
            kh.setHoTen(util.chuanHoaVietHoa(kh.getHoTen()));
            System.out.println("Số điện thoại cũ:" + kh.getSoDienThoai());
            do {
                System.out.print("Nhập số điện thoại mới: ");
                kh.setSoDienThoai(sc.nextLine());
                if ("".equals(kh.getSoDienThoai())) {
                    kh.setSoDienThoai(SDTCu);

                }
            } while (check.kiemTraSoDienThoai(kh.getSoDienThoai()));
            System.out.println("Email cũ: " + kh.getEmail());
            do {
                System.out.print("Nhập Email mới: ");
                kh.setEmail(sc.nextLine());
                if ("".equals(kh.getEmail())) {
                    kh.setEmail(emailCu);

                }
            } while (check.kiemTraEmail(kh.getEmail()));
            System.out.println("Địa chỉ cũ: " + kh.getDiaChi());
            System.out.print("Địa chỉ mới: ");
            kh.setDiaChi(sc.nextLine());
            if ("".equals(kh.getDiaChi())) {
                kh.setDiaChi(diaChiCu);
            }
            System.out.println("Số công tơ cũ: " + kh.getSoCongTo());
            System.out.print("Số công tơ mới: ");
            kh.setSoCongTo(sc.nextLine());
            if ("".equals(kh.getSoCongTo())) {
                kh.setSoCongTo(soCongToCu);
            }
            listKH.set(chiso, kh); //Đẩy thông tin mới vào list
            ghiFileKH();
            System.err.println("Cập nhật thông tin của khách hàng MSKH " + kh.getMaKH() + " thành công !");
            System.out.println("");
        }

    }
    
    public void xoaKhachHang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập mã khách hàng cần xóa: ");
        String maKH = sc.nextLine();
        KhachHang kh = timKiemMotKhachHang(maKH);
        if(kh==null){
            System.err.println("Khách hàng bạn vừa nhập không tồn tại trong hệ thống !");
        }else{
            listKH.remove(kh);
            System.err.println("Xóa thành công khách hàng có mã KH "+kh.getMaKH());
            ghiFileKH();
        }
    }

    public ArrayList<KhachHang> timKiemTheoTuKhoa() {
        ArrayList<KhachHang> listKHTimKiem = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập từ khóa cần tìm kiếm: ");
        String input = sc.nextLine();
        for (int i = 0; i < listKH.size(); i++) {
            if(listKH.get(i).getMaKH().contains(input)||listKH.get(i).getEmail().contains(input)||listKH.get(i).getSoDienThoai().contains(input)||listKH.get(i).getSoCongTo().contains(input)){
                listKHTimKiem.add(listKH.get(i));
            }
        }
        return listKHTimKiem;
    }
    int chiso; //chỉ số để get vị trí 1 khách hàng
    public KhachHang timKiemMotKhachHang(String maKH) {
        for (int i = 0; i < listKH.size(); i++) {
            if (maKH.equals(listKH.get(i).getMaKH())) {
                chiso = i;
                return listKH.get(i);
            }
        }
        return null;
    }

}
