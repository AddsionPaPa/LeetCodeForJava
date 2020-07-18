package testbank;

public class ExcelSheetColumnNumber_171 {

    public int titleToNumber(String s) {
        int length = s.length();
        int sum = 0;
        if (length == 0) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            int temp = (s.charAt(i)-'A')+1;
            sum+=(temp*Math.pow(26.0,length-i-1));
        }
        return sum;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber_171 test = new ExcelSheetColumnNumber_171();
        test.titleToNumber("A");
    }
}
