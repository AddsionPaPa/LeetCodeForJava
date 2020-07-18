package testbank;

import javafx.scene.effect.Blend;

public class PlusOne_066 {
    public static void main(String[] args){

    }
    public static int[] plusOne(int[] digits){
        int size=digits.length;
        int temp=0;
        int bit=0;
        int k=0;
        for(int i = size-1; i>=0; i--){
            if (i==size-1)k=1;
            else k=0;
            temp=(digits[i]+k+bit)%10;
            bit=(digits[i]+k+bit)/10;
            digits[i] = temp;
            if (bit == 0)break;
        }
        if (bit ==1){
            int[] newarray=new int[size+1];
//            for (int i=0; i<newarray.length; i++){
//                if (i==0){
//                    newarray[i]=1;
//                }
//                else {
//                    newarray[i]=0;
//                }
//            }
            newarray[0]=1;
            return newarray;
        }
        return digits;
    }
}
