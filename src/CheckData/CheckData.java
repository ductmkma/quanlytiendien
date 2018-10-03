/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class CheckData {

    private Pattern pattern;
    private Matcher matcher;

    public boolean kiemTraTen(String ten) {
        for (int i = 0; i < 10; i++) {
            if (ten.contains(i + "") == true || ten.equalsIgnoreCase("") == true) {
                return true;
            }
        }
        return false;
    }

    public boolean kiemTraSuaTen(String ten) {
        for (int i = 0; i < 10; i++) {
            if (ten.contains(i + "") == true) {
                return true;
            }
        }
        return false;
    }

    public boolean kiemTraSoDienThoai(String soDT) {
        boolean check = false;
        try {
            long phone = Long.parseLong(soDT);
            if (!soDT.startsWith(0 + "")) {
                System.err.println("Số điện thoại phải bắt đầu bằng số 0");
                check = true;
            } else if (soDT.length() < 10) {
                System.err.println("Số điện thoại phải lớn hơn hoặc bằng 10 số");
                check = true;
            } else if (soDT.length() > 11) {
                System.err.println("Số điện thoại phải bé hơn hoặc bằng 11 số");
                check = true;
            }
        } catch (NumberFormatException ex) {
            System.err.println("Số điện thoại không được nhập chữ.");
            check = true;
        } catch (Exception ex) {
            System.err.println("Fail" + ex.getMessage());
            check = true;
        }
        return check;
    }

    public boolean kiemTraEmail(String email) {
        String dinhDangEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        boolean ktEmail = email.matches(dinhDangEmail);
        if (ktEmail == false) {
            System.err.println("Email sai, nhập lại theo dạng abc@domain.com");
            return true;
        }
        return false;
        // String dinhDangEmail nó giống như là format chuẩn cho email mình nhập vào, nếu sai cái
        // dịnh dạng này thì là lỗi.
        // Hàm matches dùng để xác định xem chuỗi email của mình có khớp với định dạng mình đã quy 
        // định trước hay không. hàm này trả về true , false nên mình khởi tạo 1 biến ktEmail rồi gán
        // cho nó. false thì báo lỗi.
    }

    public boolean kiemTraDinhDangThangNam(String thangNam) {
        Utils util = new Utils();
        pattern = Pattern.compile(util.DATE_PATTERN);
        matcher = pattern.matcher(thangNam);
        if(matcher.matches()){
            return true;
        }
        return false;
        
    }
}
