package com.kouyy.training.algorithm;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args){
        int[] tree={1,9,2,5,3,4,8,7};
        buildHeap(tree,8);
        for (int i = 0; i < tree.length; i++) {
            System.out.println(tree[i]);
        }
    }

    //堆排序
    public static void heapSort(int[] tree){
        int n=tree.length;
        buildHeap(tree, n);
        for (int i = n-1; i >=0 ; i--) {
            swap(tree, i, 0);
            heapify(tree, i, 0);
        }
    }


    //构建一个n个节点的堆
    public static void buildHeap(int[] tree,int n){
        //找到最后一个非叶子节点的index
        int lastNode=(n-1-1)/2;
        //递归对所有的非叶子节点进行heapify
        for(int i=lastNode;i>=0;i--){
            heapify(tree, n, i);
        }
    }

    //对n个节点的二叉树的i节点进行heapify
    public static void heapify(int[] tree,int n,int i){
        if(i>=n){
            return ;
        }
        //i节点的两个叶子节点的index分别为2*i-1和2*i+1
        int c1=2*i+1;
        int c2=2*i+2;
        //先设i为max节点
        int max=i;
        if(c1<n && tree[c1]>=tree[max]){
            max=c1;
        }
        if(c2<n && tree[c2]>=tree[max]){
            max=c2;
        }
        //如果i不等于max就要交换tree[i]和tree[max]
        if(max != i){
            swap(tree,max,i);
            //继续对max节点进行heapify
            heapify(tree,n,max);
        }
    }

    public static void swap(int[] arr,int i ,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
