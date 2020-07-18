package cci;

public class StringToURL_03 {
    public String replaceSpaces(String S, int length) {
        if (length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = S.substring(0,length).toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] ==  ' '){
                stringBuilder.append("%20");

            }
            else {
                stringBuilder.append(S.substring(i,i+1));
            }
        }
        return stringBuilder.toString();
    }
}
