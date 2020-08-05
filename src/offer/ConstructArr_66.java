package offer;

public class ConstructArr_66 {
    public int[] constructArr(int[] a) {
        int sum = 1;
        int length = a.length;
        int[] b = new int[length];
        for (int i = 0; i <length ; i++) {
            sum*=a[i];
        }
        for (int i = 0; i <length ; i++) {
            b[i] = divide(sum,a[i]);
        }
        return b;
    }

    public int divide(int a, int b) {
        int dividend = a>0? a:(~a +1);
        int divisor = b>0?b:(~b +1);

        int count = 0;
        while (dividend >= divisor) {
            count++;
            dividend-=divisor;
        }
        return ((a^b) <0)?(~count+1):count;
    }
}
