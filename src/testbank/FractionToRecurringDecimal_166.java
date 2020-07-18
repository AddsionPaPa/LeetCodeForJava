package testbank;

import java.util.*;

public class FractionToRecurringDecimal_166 {

    public String fractionToDecimal(int numerator, int denominator) {
        boolean flag = false;

        String res ="";
        if (numerator == 0) {
            return "0";
        }
        if (numerator < 0 ^ denominator < 0) {
            res = "-"+res;
        }
        long reminder = Math.abs(Long.valueOf(numerator));
        long divider =Math.abs(Long.valueOf(denominator));

        Map<Long,Integer> map = new HashMap<>();
        long head,rear;
        while (true) {
            if (flag == false) {
                head = reminder/divider;
                rear = reminder%divider;
                if (rear == 0) {
                    return res+head;
                }
                else {
                    res+=head+".";
                    flag = true;
                    reminder =rear * 10;
                }
            }
            else {
                head = reminder/divider;
                rear = reminder%divider;
                if (rear == 0) {
                    return res+head;
                }
                else {
                    if (!map.containsKey(reminder)){
                        res+=head;
                        map.put(reminder,res.length());
                        reminder = rear * 10;

                    }
                    else {

                        String part1 = res.substring(0,map.get(reminder));
                        String part2 = res.substring(map.get(reminder));
                        res = part1+"("+part2+")";
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal_166 test = new FractionToRecurringDecimal_166();
        test.fractionToDecimal(-1,-2147483648);
    }
}
