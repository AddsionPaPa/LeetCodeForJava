package testbank;

public class Search2DMatrix_074 {
    public static void main(String[] args){
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
       int target=11;
        System.out.print(searchMatrix(matrix,target));

    }
    public static boolean searchMatrix(int[][] matrix,int target){
        int m=matrix.length;
        int n=matrix[0].length;

        int high=m-1;
        int low=0;
        int mid=(high+low)/2;


        int row=0;
        while (low<high){
            if(matrix[high][0]==target || matrix[low][0]==target || matrix[mid][0]==target){
                return true;
            }
            else if (matrix[mid][0]<target){
                if (matrix[mid][n-1]>=target){
                    low=mid;
                    break;
                }
                else {
                    low=mid+1;
                }
            }
            else {
                high=mid-1;
            }
            mid=(low+high)/2;
        }
        row=low;
        high=n-1;
        low=0;
        mid=(high+low)/2;
        while(low<=high){
            if (matrix[row][low]==target || matrix[row][high]==target || matrix[row][mid]==target){
                return  true;
            }
            else if (matrix[row][mid]<target){
                low = mid+1;
            }
            else {
                high=mid-1;
            }
            mid=(high+low)/2;
        }
        return false;
    }
}
