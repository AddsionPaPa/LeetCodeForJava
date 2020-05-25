import javafx.scene.shape.VLineTo;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        int length=s.length();
        if (length == 0) {
            return true;
        }
        int left = 0;
        int right = length-1;
        while (left < right) {
            while ((left<right)&&!(s.charAt(left) <= 'z' && s.charAt(left) >= 'a') && !(s.charAt(left) <= 'Z' && s.charAt(left) >= 'A') && !(s.charAt(left) >= '0' && s.charAt(left) <= '9')) {
                left++;
            }
            while ((left<right)&&!(s.charAt(right) <= 'z' && s.charAt(right) >= 'a') && !(s.charAt(right) <= 'Z' && s.charAt(right) >= 'A') && !(s.charAt(right) >= '0' && s.charAt(right) <= '9')) {
                right--;
            }
            int left_char=s.charAt(left);
            int right_char= s.charAt(right);
            if (!(left_char == right_char|| (Math.abs(left_char - right_char) == 32)&&(!(left_char<='9'&&left_char>='0' || right_char<='9'&& right_char>='0')))) {

                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_125 test= new ValidPalindrome_125();
        test.isPalindrome("0P");
        String s = "213124";
        System.out.println(s.substring(5,6));
    }
}
