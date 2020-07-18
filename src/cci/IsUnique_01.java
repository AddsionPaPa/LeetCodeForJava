package cci;

public class IsUnique_01 {
    /**
     * 利用位运算
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {

        long high_bit = 0;
        long low_bit = 0;

        long move_bit = 0;

        for (int i = 0; i < astr.length(); i++) {
            int move = astr.charAt(i);

            if (move >=64){
                move_bit = 1 << (move-64);

                if ((move_bit & high_bit) != 0) {
                    return false;
                }
                else {
                    high_bit |= move_bit;
                }

            }
            else {
                move_bit = 1 << move;

                if ((move_bit & low_bit) != 0){
                    return false;
                }
                else {
                    low_bit |= move_bit;
                }
            }
        }
        return  true;
    }
}
