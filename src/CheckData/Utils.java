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
public class Utils {

    public static final int DON_GIA_BAC_1 = 1484;
    public static final int DON_GIA_BAC_2 = 1533;
    public static final int DON_GIA_BAC_3 = 1786;
    public static final int DON_GIA_BAC_4 = 2242;
    public static final int DON_GIA_BAC_5 = 2503;
    public static final int DON_GIA_BAC_6 = 2587;
    public static final int MAX_BAC_1 = 50;
    public static final int MAX_BAC_2 = 50;
    public static final int MAX_BAC_3 = 100;
    public static final int MAX_BAC_4 = 100;
    public static final int MAX_BAC_5 = 100;

    static final String DATE_PATTERN = "([1-9]|1[012])_((19|20)\\d\\d)";

    public String chuanHoaKhoangTrang(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }

    public String chuanHoaVietHoa(String str) {
        str = chuanHoaKhoangTrang(str);
        String arr[] = str.split(" ");
        str = "";
        for (int i = 0; i < arr.length; i++) {
            str += String.valueOf(arr[i].charAt(0)).toUpperCase() + arr[i].substring(1);
            if (i < arr.length - 1) {
                str += " ";
            }
        }
        return str;
    }

    public boolean kiemTraEmail(String email) {
        String dinhDangEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        boolean ktEmail = email.matches(dinhDangEmail);
        if (ktEmail == false) {
            System.err.println("Email sai, nhập lại theo dạng abc@domain.com");
            return true;
        }
        return false;
    }

}
