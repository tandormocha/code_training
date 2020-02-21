package com.kouyy.training.algorithm;

/**
 *归并排序
 */
public class MergeSort {
    public static void main(String[] args){
        int[] m={1,3,5,7,9,11,13,15,17};
        int[] n={10,8,6,4,2};
        int[] resArr = joinAndSortArray(m, n);
        for (int i : resArr) {
            System.out.println(i);
        }
    }

    public static int[] joinAndSortArray(int[] m,int[] n){
        int[] resArr=new int[m.length+n.length];
        int i=0;
        int j=n.length-1;
        while(j>=0 && i<=m.length-1){

            if(j>=0 && i<=m.length-1&& n[j]<=m[i]){
                resArr[i+n.length-1-j]=n[j];
                    j--;
            }

            if(i<=m.length-1 && j>=0 && n[j]>m[i]){
                resArr[i+n.length-1-j]=m[i];
                    i++;
            }

            if(m[m.length-1]>n[0]){

                for (int k = n.length-1; k <= m.length-1 ; k++) {
                    resArr[n.length+k]=m[k];
                }
                
            }else if(n[0]>m[m.length-1]){

                for (int k = 0; k <=n.length-m.length; k++) {
                    resArr[2*m.length-1+k]=n[n.length-m.length-k];
                }
                
            }


        }

        return resArr;
    }
}
