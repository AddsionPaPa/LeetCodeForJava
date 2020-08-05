package testbank;

public class RangeBitwiseAnd_201 {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int bit = 0;
        while (m != n) {
            m>>=1;
            n>>=1;
            bit++;
        }
        return m<<bit;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE+"->"+Integer.MAX_VALUE);
    }
}
