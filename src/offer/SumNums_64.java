package offer;

import org.junit.Test;

import java.sql.SQLOutput;

public class SumNums_64 {

    public int sumNums(int n) {
        int res=0,a = n,b=n+1;
        boolean flag;
        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;

        flag = ((b&1) > 0) && (res+=a)>0;
        a<<=1;
        b>>=1;
        return res;
    }

    @Test
    public void fun() {
        int a=13;
        System.out.println(Integer.toBinaryString(10000));
    }
}
