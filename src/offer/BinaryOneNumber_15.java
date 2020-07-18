package offer;

public class BinaryOneNumber_15 {
    public int hammingWeight(int n) {
        int verify_bit = 1;
        int count = 0;
        for (int i = 1; i < 33; i++) {
            verify_bit = verify_bit & n;
            if (verify_bit == 1) {
                count++;
            }
            else {
                verify_bit = 1;
            }

            n = n >> 1;
        }
        return count;
    }
}
