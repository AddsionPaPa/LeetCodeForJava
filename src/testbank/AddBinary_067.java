package testbank;

public class AddBinary_067 {
    public static void main(String[] args){
        String a = "1";
        String b = "111";
        String c=addBinary(a,b);
        System.out.print(c);
    }
    public static String addBinary(String a ,String b){
        String temp="";
        int alength=a.length();
        int blength=b.length();
        int bit=0;
        int tempsum=0;
        String tempstr=null;
        int k=0;
        if (blength>alength) {
            tempstr = b;
            b = a;
            a = tempstr;
            k=alength;
            alength=blength;
            blength=k;

        }
        alength--;
        blength--;
        while (blength>=0 ||alength>=0 ){
//            int k=b.charAt();
            if (blength<0){
                tempsum=  a.charAt(alength)-'0'  + bit;
            }
            else{
                tempsum=  a.charAt(alength)-'0' + b.charAt(blength) - '0' + bit;
            }
            bit=tempsum/2;
            temp=String.valueOf(tempsum%2)+temp;
            alength--;
            blength--;
        }
        if (bit !=0){
            temp="1"+temp;
        }
        return  temp;
    }
}
