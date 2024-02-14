package org.example.Algoritm._2024_02_12;

public class Alg {
    public static void main(String[] args) {

        System.out.println(S2(4,5));
    }
    public static int  S1(int n){
        if(n<=0) throw new IllegalArgumentException();
        if(n==1)return 1;
        return S1(n-1)+1+(n-1)*2;
    }
    public static int  S2(int n,int x){
        if(n<=0) throw new IllegalArgumentException();
        if(n==1)return 1;
        return S2(n-1,x)+1+(n-1)*x;
    }
    public static int  Feb(int n){
        if(n<=0) throw new IllegalArgumentException();
//        if(n==1)return 0;
//        if(n==2)return 1;
        if(n==1||n==2) return n-1;
        return Feb(n-1)+Feb(n-2);
    }
    public static int binarySearchRecurs(int[] arr, int num,int start,int end) {
        if(start>end) throw new IllegalArgumentException();
        int mid = (end + start) / 2;
       if(num>arr[mid])return binarySearchRecurs(arr,num,mid+1,end);
       else if(num<arr[mid])return binarySearchRecurs(arr,num,start,mid-1);
       else return mid;

    }


}
