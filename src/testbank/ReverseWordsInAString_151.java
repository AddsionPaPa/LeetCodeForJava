package testbank;

public class ReverseWordsInAString_151 {
    public String reverseWords(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }
        String sum = "";
        // 双指针定位
        int start = 0;
        int end = start;
        while (start<length) {
            while(start<length && s.charAt(start)==' '){
                start++;
            }
            end =start;
            while (start<length && end<length && s.charAt(end)!=' '){
                end++;
            }
            if (start < length) {
                String sub_str = s.substring(start,end);
                sum = " "+ sub_str+sum;
            }
            start = end;
        }
        return sum.trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAString_151 test = new ReverseWordsInAString_151();
        System.out.println(test.reverseWords("the sky is blue"));
    }
}
