package offer;

import org.junit.Test;

import java.util.TreeMap;

public class NumberOneAppear_43 {

    public int countDigitOne(int n) {
        int high;
        int low;
        int cur;
        int sum =0 ;
        int digit =1;
        int sum_digit = 0;
        int number =n;
        while (number  != 0) {
            sum_digit++;
            number= number/10;
        }

        for (int i = 1; i <= sum_digit; i++) {
            if (i == 1) {
                cur = n % 10;
                high = n / 10;
                low = 0;

            } else {
                low = n%(digit);
                if (i==sum_digit){
                    high = 0;
                }
                else {
                    high = n/(digit*10);
                }
                cur = (n/digit)%10;
            }

            if (cur == 0) {
                sum+=(high*digit);
            } else if (cur == 1) {
                sum += (high * digit + low + 1);
            } else {
                sum+=((high+1)*digit);
            }

            digit*=10;

        }
        return sum;
    }

    @Test
    public void fun() {
//        countDigitOne(1410065408);
        System.out.println(1410065408/1000000000);

    }
}
