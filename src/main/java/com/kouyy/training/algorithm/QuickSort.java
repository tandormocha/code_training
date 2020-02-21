package com.kouyy.training.algorithm;

/**
 * 快排
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //快速排序
    public static void quickSort(int[] arr,int low,int high){
        if(low < high){
            int index=getIndex(arr,low,high);
            quickSort(arr, 0, index-1);
            quickSort(arr, index+1, high);
        }
    }

    //找到分界点的索引
    public static int getIndex(int[] arr,int low,int high){
        int temp=arr[low];
        while(low<high){
            //从后向前扫描
            while(low<high && arr[high]>=temp){
                high--;
            }
            arr[low]=arr[high];
            //从前向后扫描
            while(low<high && arr[low]<=temp){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }
}
