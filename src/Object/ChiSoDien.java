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
public class ChiSoDien {
    private String maKH;
    private int chiSoCu;
    private int chiSoMoi;
    private int thang;
    private int nam;
    private int trangThai;

    public ChiSoDien() {
    }
    
    public ChiSoDien(String maKH, int chiSoCu, int chiSoMoi, int thang, int nam, int trangThai) {
        this.maKH = maKH;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        this.thang = thang;
        this.nam = nam;
        this.trangThai = trangThai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getChiSoCu() {
        return chiSoCu;
    }

    public void setChiSoCu(int chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public int getChiSoMoi() {
        return chiSoMoi;
    }

    public void setChiSoMoi(int chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
