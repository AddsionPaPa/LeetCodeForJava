import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses_093 {
    public static void main(String[] args){
        RestoreIPAddresses_093 test=new RestoreIPAddresses_093();
        List<String> a=test.restoreIpAddresses("25525511135");
        System.out.println(a);
    }
    public List<String> restoreIpAddresses(String s){
        List<String> res=new LinkedList<>();
        Deque<String> path=new LinkedList<>();
//        int split_time=0;
        DFS(s,0,0,res,path);


        return res;
//        if (s.length()<4 || s.length()>12){
//            return res;
//        }
    }
    public int judge(String s,int left,int right, int split_time){
        if ((right-left+1)>1 && s.charAt(left)=='0'){
            return -1;
        }
        if (right>=s.length()) {
            return  -1;
        }
        int count=0;
        for (int i=left; i<=right;  i++){
            count=count*10+s.charAt(i)-'0';
        }
        if (count>255){
            return -1;
        }
        return count;
    }
    public void DFS(String s, int split_time, int begin, List<String> res, Deque<String> path){
        if (split_time==4){
            if (begin==s.length()){
                res.add(String.join(".",path));
            }
            return;
        }
        if ((s.length()-begin)<(4-split_time) || (s.length()-begin)>3*(4-split_time)){
            return;
        }
        for (int i=0;i<3;i++){
            if (judge(s,begin,begin+i,split_time)!=-1){
                path.add(s.substring(begin,begin+i+1));
                DFS(s,split_time+1,begin+i+1,res,path);
                path.removeLast();
            }
        }

    }
}
