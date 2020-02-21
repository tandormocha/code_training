package com.kouyy.training.algorithm;

/**
 * 常用排序算法
 */
public class Sort {
    public static void main(String[] args){
        int[] arr={ 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }


    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    //选择排序
    public static void selectSort(int[] arr){
        //从左向右遍历arr找出最小的数
        for (int i = 0; i < arr.length; i++) {
            int mini=i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j]<arr[mini]){
                    mini=j;
                }
            }
            //如果mini不等于i就交换值
            if(mini != i){
                swap(arr, mini, i);
            }
        }
    }


    //冒泡排序
    public static void maopaoSort(int[] arr){
        //从左向右遍历数组，依次与后面一个元素比较，如果后面比前面大就交换位置
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }


    //快速排序
    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int index=getIndex(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }

    public static int getIndex(int[] arr,int low,int high){
        int temp=arr[low];
        while(low < high){
            while (low<high && arr[high]>=temp){
                high--;
            }
            arr[low]=arr[high];
            while (low < high && arr[low]<=temp){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }

    //堆排序
    public static void heapSort(int[] tree){
        int n=tree.length;
        buildHeap(tree, n);
        //从最后一个节点开始依次与堆顶进行交换
        for (int i = n-1; i >=0 ; i--) {
            swap(tree, i, 0);
            //对剩余节点heapify
            heapify(tree, i, 0);
        }
    }


    //构建一个n个节点的堆
    public static void buildHeap(int[] tree,int n){
        //从最后一个非叶子节点开始向上依次heapify
        int lastNode=(n-1-1)/2;
        for (int i = lastNode; i >=0 ; i--) {
            heapify(tree,n,i);
        }
    }

    //指定一个节点，从该节点向下为一个堆
    public static void heapify(int[] tree,int n,int i){
        int max=i;
        int c1=2*i+1;
        int c2=2*i+2;
        if(c1<n && tree[c1]>tree[max]){
            max=c1;
        }
        if(c2<n && tree[c2]>tree[max]){
            max=c2;
        }
        if(max != i){
            swap(tree, max, i);
            //继续以max节点为节点继续heapify下去
            heapify(tree,n,max);
        }
    }







}
