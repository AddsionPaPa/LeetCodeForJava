package cci;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Main t= new Main();
        t.fun(array,0,n-1);
        System.out.println(t.min);
    }

    public void fun(int[] array, int low, int high) {
        if (low == high) {
            min=Math.min(min,array[low]);
            return;
        } else if (low + 1 == high) {
            min = Math.min(array[low], Math.min(array[high], min));
        } else {
            int mid = (low+high)/2;
            fun(array,low,mid);
            fun(array,mid+1,high);
        }
    }
}
