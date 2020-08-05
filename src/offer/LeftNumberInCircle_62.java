package offer;

public class LeftNumberInCircle_62 {

    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int temp = 0;
        for (int i = 1; i <n ; i++) {
            temp = (temp+m)%(i+1);
        }
        return temp;
    }
}
