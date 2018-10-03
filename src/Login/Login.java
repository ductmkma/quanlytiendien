/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import App.ChiSoDienApp;
import App.HoaDonApp;
import App.KhachHangApp;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Login {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String acc,pass;
        int dem =0;
        do {
            System.out.println("+--------------------ĐĂNG NHẬP----------------+");
            System.out.print("Mời bạn nhập tài khoản: ");
            acc = sc.nextLine();
            System.out.print("Nhập mật khẩu: ");
            pass = sc.nextLine();
            if (acc.equals("admin") && pass.equals("123456")) {
                dem++;
                System.err.println("Đăng nhập thành công !");
                new Login().mainMenu();
            } else {
                System.err.println("Tài khoản hoặc mật khẩu sai !");
            }
        } while (dem==0);

    }
    public void mainMenu(){
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("+-------------QUẢN LÝ THANH TOÁN TIỀN ĐIỆN-----------+");
            System.out.println("|             1. QUẢN LÝ KHÁCH HÀNG                  |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("|             2. QUẢN LÝ CHỈ SỐ ĐIỆN KHÁCH HÀNG      |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("|             3. QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN HÀNG THÁNG|");
            System.out.println("+----------------------------------------------------+");
            System.out.println("|             4. THOÁT                               |");
            System.out.println("+----------------------------------------------------+");
            System.out.print("Mời bạn chọn chức năng: ");
            Scanner input = new Scanner(System.in);
            chon = input.nextInt();
            switch (chon) {
                case 1: {
                    KhachHangApp khApp = new KhachHangApp();
                    khApp.menuKH();
                }
                break;
                case 2: {
                    ChiSoDienApp csd = new ChiSoDienApp();
                    csd.nhapThoiGian();
                }
                break;
                case 3: {

                    HoaDonApp hdApp = new HoaDonApp();
                    hdApp.menu();
                }
                break;
                case 4: {
                    System.exit(0);
                }
                break;
                default: {
                    System.out.println("Bạn chọn sai chức năng !");
                }
            }
        } while (chon != 4);
        
    }

}
