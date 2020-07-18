package cci;

public class CompressString_06 {
    public String compressString(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        if (S.length() == 0 || S.length() == 1) {
            return  S;
        }
        int count = 1;
        int pos=0;
        while (pos < S.length()) {
            if (pos == 0 || S.charAt(pos) != S.charAt(pos - 1)) {
                stringBuilder.append(S.charAt(pos));
                pos++;
                while (pos<S.length()&& S.charAt(pos)==S.charAt(pos-1)){
                    count++;
                    pos++;
                }
                stringBuilder.append(Integer.toString(count));
                count = 1;
            }
        }
        if (stringBuilder.length() < S.length()) {
            return stringBuilder.toString();
        }
        return S;
    }

    public static void main(String[] args) {
        CompressString_06 test = new CompressString_06();
        test.compressString("aabcccccaa");
    }
}
