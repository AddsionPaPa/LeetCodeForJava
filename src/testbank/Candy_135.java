package testbank;

public class Candy_135 {
    public static void main(String[] args) {
        Candy_135 test = new Candy_135();
        test.candy(new int[]{1,2,2});
    }
    public int candy(int[] ratings) {
        int sum = 0;
        int length = ratings.length;
        int previous = -1;
        for (int i = 0; i < length ; i++) {
            if (i == 0) {
                sum+=1;
                previous = 1;
            }
            else {
                if (ratings[i] < ratings[i - 1]) {
                    if(previous==1){
                        sum+=(i+1);
                    }
                    else {
                        previous =1;
                        sum+=previous;
                    }
                }
                else if (ratings[i] > ratings[i - 1]) {
                    previous++;
                    sum+=previous;
                }
                else {
                    previous=1;
                    sum+=previous;
                }

            }
        }
        return sum;
    }
}
