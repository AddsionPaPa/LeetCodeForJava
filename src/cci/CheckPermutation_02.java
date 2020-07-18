package cci;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation_02 {
    public boolean CheckPermutation(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            int t = map.getOrDefault(c,0);
            map.put(c,t+1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!map.containsKey(c)){
                return false;
            }
            else {
                int t = map.get(c);
                if (t == 1) {
                    map.remove(c);
                }
                else {
                    map.put(c,t-1);
                }
            }
        }
        if (map.size()==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final Map<Thread,String> map = new HashMap<>();
        map.put(Thread.currentThread(),"hello");
        System.out.println(Thread.currentThread().toString());

        new Thread(){
            public void run() {
                System.out.println(Thread.currentThread().toString());
            }
        }.start();
    }
}
