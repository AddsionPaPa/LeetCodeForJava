package testbank;

public class CompareVersionNumbers_165 {
    public int compareVersion(String version1, String version2) {

        String[] str1_split = version1.split("\\.");
        String[] str2_split = version2.split("\\.");

        int str1_length = str1_split.length;

        int str2_length = str2_split.length;

        int min = (str1_length>str2_length)? str2_length:str1_length;

        for (int i = 0; i < min; i++) {
            int temp1 = Integer.parseInt(str1_split[i]);
            int temp2 = Integer.parseInt(str2_split[i]);

            if (temp1 < temp2) {
                return -1;
            }
            if (temp1 > temp2) {
                return 1;
            }
        }
        int pos =min;
        if (str1_length > min) {
            while (pos < str1_length) {
                if (Integer.parseInt(str1_split[pos]) > 0) {
                    return 1;
                }
                pos++;
            }
        }
        if (str2_length > min) {
            while (pos < str2_length) {
                if (Integer.parseInt(str2_split[pos]) > 0) {
                    return -1;
                }
                pos++;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        CompareVersionNumbers_165 test =new CompareVersionNumbers_165();
        test.compareVersion("0.1","1.1");
    }
}
