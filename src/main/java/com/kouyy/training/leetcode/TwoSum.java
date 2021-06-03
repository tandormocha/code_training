package com.kouyy.training.leetcode;

import java.util.HashMap;
import java.util.Map;

/*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。*/
public class TwoSum {

    //解法1：直接两遍遍历
    public int[] twoSum1(int[] nums, int target) {
        int[] a=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    a[0]=i;
                    a[1]=j;
                }
            }
        }
        return a;
    }

        //利用哈希表
        /*public Integer[] twoSum2(Integer[] nums, Integer target) {
            Map map=new HashMap<Integer,Integer>();
            Integer[] a=new Integer[2];
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                Integer complement=target-nums[i];
                if(map.containsKey(complement)&&map.get(complement)!=i) {
                    a[0] = i;
                    a[1] = map.get(complement);
                }
            }
            return a;
        }*/




}
