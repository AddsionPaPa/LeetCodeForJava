package testbank;

public class ReverseBits_190 {


    public int reverseBits(int n) {
        int last_bit = 0;
        int res = 0;

        for (int i = 1; i <=32 ; i++) {
            last_bit = (n&1);

            res<<=1;
            res+=last_bit;
            n>>=1;

            if (n == 0) {
                res<<=(32-i);
                return res;
            }
        }
        return res;
    }
}
