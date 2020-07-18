package offer;

import org.junit.Test;

import javax.xml.stream.FactoryConfigurationError;

public class RegularExpression_19 {

    public boolean isMatch(String s, String p) {
        int row = p.length();
        int col = s.length();
        boolean[][] dp = new boolean[row+1][col+1];
        for (int i = 0; i < col + 1; i++) {
            dp[0][i] = false;
        }
        dp[0][0] =true;
        for (int j = 1; j < row + 1; j++) {
            if (j > 1 && p.charAt(j-1)=='*'&& dp[j - 2][0]) {
                dp[j][0] =true;
            }
            else dp[j][0] = false;
        }


        for (int i = 1; i < row + 1; i++) {
            char p_c = p.charAt(i-1);
            for (int j = 1; j < col + 1; j++) {
                char s_c = s.charAt(j-1);
                if (p_c != '*' && p_c != '.') {
                    dp[i][j] = dp[i-1][j-1]&&(p_c==s_c);
                } else if (p_c == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }

                else if (p_c =='*'){
                    // 处理 “.*”的情况
                    if (i > 1 && p.charAt(i-2)=='.') {

                        dp[i][j] = dp[i][j-1] || dp[i-2][j-1]||dp[i-2][j];
                    }
                    else {
                        dp[i][j] = dp[i-1][j] || dp[i-2][j] || (dp[i-1][j-1] && s_c==p.charAt(i-2));
                    }
                }
                else dp[i][j]= false;

            }
        }
        for (int i = 0; i < row + 1; i++) {
            for (int j = 0; j < col + 1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[p.length()][s.length()];
    }

    @Test
    public void fun() {
        isMatch("aasdfasdfasdfasdfas",
                "aasdf.*asdf.*asdf.*asdf.*s");
    }
}
