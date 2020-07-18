package cci;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation_04 {
    public boolean canPermutePalindrome(String s) {
        int length = s.length();

            Set<Character> set =new HashSet<>();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (set.contains(c)) {
                    set.remove(c);
                }
                else {
                    set.add(c);
                }
            }
            if (set.size() == 1 || set.size()==0) {
                return true;
            }
            return false;

    }

    public static void main(String[] args) {
        PalindromePermutation_04 test =new PalindromePermutation_04();
        test.canPermutePalindrome("abdg");
    }
}
