import java.awt.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_076 {
    public static void main(String[] args){
        minWindow("ab","a");
    }
    public static String minWindow(String s,String t){
//         int s_head=0;
//         int s_rear=s.length()-1;
//         int t_head=0;
//         int t_rear=t.length()-1;
//         if (t_rear>s_rear)return "";
//         String temp_t="";
//         String temp_s="";
//         boolean headflag=true;
//         boolean rearflag=true;
//         while (s_head<=s_rear){
//             temp_s=s.substring(s_head);
//             for (int i=0 ; i<t.length(); i++){
//                 if (temp_s.indexOf(t.substring(i,i+1))==-1){
//                     if (s_head==0){
//                         return "";
//                     }
//                     else {
//                         s_head-=1;
//                         headflag=false;
//                         break;
//                     }
//                 }
//             }
//             if (headflag==true){
//                 s_head++;
//                 if (s_head>s_rear){
//                     s_head--;
//                     break;
//                 }
//             }
//             else {
//                 break;
//             }
//         }
//        while (s_head<=s_rear){
//            temp_s=s.substring(s_head,s_rear+1);
//            for (int i=0 ; i<t.length(); i++){
//                if (temp_s.indexOf(t.substring(i,i+1))==-1){
//                        s_rear++;
//                        rearflag=false;
//                        break;
//                }
//            }
//            if (rearflag==true){
//                s_rear--;
//                if (s_rear<s_head){
//                    s_rear++;
//                    break;
//                }
//            }
//            else {
//                break;
//            }
//        }
//        System.out.print(s.substring(s_head,s_rear+1));
//        return s.substring(s_head,s_rear+1);
        if (s.length()==0 || t.length()==0){
            return "";
        }

        int start=0;
        int right=0,left=0;
        int matched=0;
        int minlenth=-1;

        Map<Character,Integer>  dict=new HashMap<Character, Integer>();
        Map<Character,Integer> window=new HashMap<Character, Integer>();
        for (int i=0;i<t.length();i++){
            int count=dict.getOrDefault(t.charAt(i),0);
            dict.put(t.charAt(i),count+1);
        }

        while (right<s.length()){
            if (dict.containsKey(s.charAt(right))) {
                int count=window.getOrDefault(s.charAt(right),0);
                window.put(s.charAt(right),count+1);
                if (window.get(s.charAt(right))==dict.get(s.charAt(right))){
                    matched++;
                }
            }
            right++;
            while (matched==dict.size()){
                if (minlenth==-1||right-left<minlenth){
                    start=left;
                    minlenth=right-left;
                }
                if (dict.containsKey(s.charAt(left))){
                    int count=window.get(s.charAt(left));
                    window.put(s.charAt(left),count-1);
                    if (window.get(s.charAt(left))<dict.get(s.charAt(left))){
                        matched--;
                    }
                }
                left++;
            }
        }
        return minlenth==Integer.MAX_VALUE?"":s.substring(start,start+minlenth-1);
    }
}
