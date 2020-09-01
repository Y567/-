package 笔试.拼多多;

import java.util.Scanner;

public class 多多的矩阵 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextInt()){
            int n = input.nextInt();
            int[][] arr = new int[n][n];
            int mid = -1;
            if(n%2==1){
                mid = (n-1) / 2;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = -1;
                    if(i == j || (i == (n - j - 1))){
                        arr[i][j] = 0;
                    }
                    if(mid != -1){
                        if(i == mid || j == mid){
                            arr[i][j] = 0;
                        }
                    }
                }
            }
            if(n % 2 == 0){
                mid = n / 2;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == 0){
                        continue;
                    }
                    if(i < mid && j >= mid && i < (n - j - 1)){
                        arr[i][j] = 1;
                    }
                    if(i < mid && j < mid && i < j){
                        arr[i][j] = 2;
                    }
                    if(i < mid && j < mid && i > j){
                        arr[i][j] = 3;
                    }
                    if(i >= mid && j < mid && i < (n - j - 1)){
                        arr[i][j] = 4;
                    }if(i > mid && j < mid && i > (n - j - 1)){
                        arr[i][j] = 5;
                    }
                    if(i > mid && j >= mid && i > j){
                        arr[i][j] = 6;
                    }if(i >= mid && j > mid && i < j){
                        arr[i][j] = 7;
                    }if(i < mid && j > mid && i > (n - j - 1)){
                        arr[i][j] = 8;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(j == n -1){
                        System.out.println(arr[i][j]);
                    }else{
                        System.out.print(arr[i][j] + " ");
                    }
                }
            }
        }
    }
}
