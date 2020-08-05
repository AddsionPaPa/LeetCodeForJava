package offer;

public class PlusWithoutPlusMinusMultiplyDivide_65 {

    public int add(int a, int b) {
        int forward_bit, raw_bit;

        raw_bit = (a^b);
        forward_bit = (a&b)<<1;

        while (forward_bit == 0) {
            int temp = raw_bit;
            temp = (raw_bit^forward_bit);
            forward_bit = (forward_bit&raw_bit)<<1;
            raw_bit = temp;
        }
        return raw_bit;
    }
}
