public class Sqrt_x_069 {
    public  static  void main(String[] args){

    }

    public static int mySqrt(int x){
        double low=0;
        double high=(double)x;
        double mid=(low + high)/2;
        while (Math.abs(Math.pow(mid,2)-(double)x)>1e-2){
            if((Math.pow(mid,2)-(double)x)>0){
                high=mid;
            }
            else {
                low=mid;
            }
            mid = (low + high)/2;
        }

        return (int)Math.floor(mid);
    }
}
