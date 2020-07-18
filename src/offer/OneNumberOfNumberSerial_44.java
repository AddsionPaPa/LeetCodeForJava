package offer;

import org.junit.Test;

import java.util.Arrays;

public class OneNumberOfNumberSerial_44 {

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int digit = 1;
        // 每次循环后的相对位置
        int temp = n;
        int bit_sum = (int) (9 * Math.pow(10, digit - 1) * digit);
        while (temp > bit_sum) {
            temp -= bit_sum;
            digit++;
            bit_sum = (int) (9 * Math.pow(10, digit - 1) * digit);
        }
        int cur_number  = (int)Math.pow(10,digit-1)+ (temp-1)/digit;
        int order = (temp-1)%digit;

        return getNth(cur_number,order,digit);
    }

    public int getNth(int n, int order,int digit) {
        int bit = digit - order;
        int i=1;
        int k = 0;
        while (i <= bit) {
            k = n%10;
            n = n/10;
            i++;
        }
        return k;
    }

    @Test
    public void fun() {
        getNth(123,1,3);
        "ad".compareTo("da");
    }
}
