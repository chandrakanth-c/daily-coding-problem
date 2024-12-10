/******************************************************************************

>>>> Below paragraphs are sourced from the email from dailycodingproblem.com.

This problem was asked by Microsoft.

Given an array of numbers, find the length of the longest increasing subsequence (LIS) in the array. 
The subsequence does not necessarily have to be contiguous.

For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], 
the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.

*******************************************************************************/

import java.util.*;
public class Main
{
    private static final Map<Integer,Integer> cache;
    
    static{
        cache=new HashMap<>();
    }
    
    private static int longestIncreasingSubseq(int[] arr){
        if(arr.length==0 || arr.length==1) return arr.length;
        int greatestOfPrev=Integer.MIN_VALUE;
        int lisRes=1;
        
        if(arr[1]>arr[0]) {
            lisRes=2;
            cache.put(1,lisRes);
            greatestOfPrev=arr[1];
        }else{
            cache.put(1,1);
            greatestOfPrev=arr[0];
        }
        
        for(int i=2;i<arr.length;i++){
            if(arr[i]>greatestOfPrev){
                lisRes=cache.get(i-1)+1;
                cache.put(i,lisRes);
                greatestOfPrev=arr[i];
            }else{
                cache.put(i,lisRes);
            }
        }
        
        return cache.get(arr.length-1);
    }
    
	public static void main(String[] args) {
		//Test Case 1 : expected output is 3
		System.out.println(
		    longestIncreasingSubseq(new int[]{3,2,10,11}));
		//Test Case 1 : expected output is 6
		System.out.println(
		    longestIncreasingSubseq(new int[]{0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}));
		
	}
}
