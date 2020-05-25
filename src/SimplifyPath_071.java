import java.util.Stack;

public class SimplifyPath_071 {
    public static  void  main(String[] args){
         String p="/home/";
         System.out.print(simplyfyPath(p));
//        simplyfyPath(p);
    }


    public  static String simplyfyPath(String path ){
        String res="";
        String[] splitstring=path.split("/");
        for (String a: splitstring
             ) {
            System.out.print("|*"+a+"*|");
        }
        Stack<String> stack=new Stack<String>();
        System.out.print(splitstring[0].equals(""));
        for (int i=0 ; i< splitstring.length; i++){
            if ( !splitstring[i].equals(".") && !splitstring[i].equals("") && !splitstring[i].equals("..")){
                stack.push(splitstring[i]);
            }
            if (splitstring[i].equals("..") && !stack.isEmpty()){
                stack.pop();
            }

        }
        System.out.print("stack:"+stack);
        int i=0;
        while (!stack.empty()){
            String str=stack.pop();
//            if (!stack.isEmpty()){
                res="/"+str+res;


//            System.out.print(stack.isEmpty());
//            System.out.print(res);
//            System.out.print(++i);
//            System.out.print(stack.pop());
//            stack.pop();
        }
        if (res=="") return "/";
        return res;
    }
}
