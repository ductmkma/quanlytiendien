/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String maHD;
    private String maKH;
    private int thang;
    private int nam;
    private int tongSoDien;
    private int thanhTien;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maKH, int thang, int nam, int tongSoDien, int thanhTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.thang = thang;
        this.nam = nam;
        this.tongSoDien = tongSoDien;
        this.thanhTien = thanhTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getTongSoDien() {
        return tongSoDien;
    }

    public void setTongSoDien(int tongSoDien) {
        this.tongSoDien = tongSoDien;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    

   
   
    
    
}
