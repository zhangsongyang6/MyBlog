package com.study;
 
public class Test4 {
    public static void main(String[] args) {
        int[] arr1 = {19,21,24,27};
        int[] arr2 = new int[arr1.length];
 
        copy(arr1,arr2);
        printArray(arr1);
        printArray(arr2);
 
    }
 
    public static void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1? arr[i]:arr[i]+",");
        }
        System.out.println("]");
    }
 
    public static void copy(int[] arr1,int[] arr2){
       //正式完成元素的复制
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }
}